package pers.guzx.consumerservice.controller;

import feign.Feign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import pers.guzx.consumerservice.client.CustomRemoteClient;
import pers.guzx.consumerservice.pojo.House;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/1 14:13
 * @describe
 */
@RestController
@RequestMapping("/call")
@Slf4j
public class HouseClientController {

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/houseData")
    public House getData(@RequestParam("name") String name) {
        log.info("call请求参数：" + name);
        return restTemplate.getForObject("http://localhost:81/houseData?name=" + name, House.class);
    }

    @GetMapping("/paramData/{name}")
    public String getParamData(@PathVariable("name") String name) {
        return restTemplate.getForObject("http://localhost:81/paramData/{name}", String.class, name);
    }

    @GetMapping("/entityData")
    public House getEntity(@RequestParam("name") String name) {
        ResponseEntity<House> responseEntity = restTemplate.getForEntity("http://localhost:81/houseData?name=" + name, House.class);
        if (responseEntity.getStatusCodeValue() == 200) {
            return responseEntity.getBody();
        }
        return null;
    }


    @GetMapping("/saveHouseData")
    public Long saveHouse() {
        House house = new House(2L, "广东省", "深圳市", "南山区");
        Long id = restTemplate.postForObject("http://localhost:81/saveHouse", house, Long.class);
        return id;
    }

    @GetMapping("/deleteHouse/{houseId}")
    public Long deleteHouse(@PathVariable("houseId") Long houseId) {
        restTemplate.delete("http://localhost:81/deleteHouse/{houseId}", houseId);
        return houseId;
    }

    @GetMapping("/exchange")
    public Object exchangeHouse() {
        // 定义请求头
        HttpHeaders heads = new HttpHeaders();
        heads.setContentType(MediaType.APPLICATION_JSON);
        // 定义请求参数
        Map<String, Object> params = new HashMap<>();
        params.put("houseId", 2);
        // 请求地址
        String url = "http://localhost:81/deleteHouse/{houseId}";
        int deleteHouseId = 2;
        HttpEntity httpEntity = new HttpEntity(params, heads);
        ResponseEntity responseEntity = restTemplate.exchange(url, HttpMethod.DELETE, httpEntity, Long.class, deleteHouseId);
        return responseEntity.getBody();
    }

    @GetMapping("/eureka")
    public House eurekaTest(@RequestParam("name") String name) {
        log.info("call eureka请求参数：" + name);
        String url = "http://client-service/houseData?name=" + name;
        return restTemplate.getForObject(url, House.class);
    }

    @Resource
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/serviceByRibbon")
    public Object serverData() {
        String serviceName = "client-service";
        ServiceInstance serviceInstance = loadBalancerClient.choose(serviceName);
        return serviceInstance;
    }

    @Resource
    private CustomRemoteClient client;

    @GetMapping("/remoteClient")
    public String remoteClient() {
        String result = client.clientTest();
        log.info("调用结果：" + result);
        return result;
    }

    @GetMapping("/remoteAutoTask")
    public String remoteAutoTask() {
        String result = client.autoTask();
        log.info("调用结果：" + result);
        return result;
    }

}
