package pers.guzx.consumerservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/3/31 10:43
 * @describe
 */
@RestController
public class ConsumerController {

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/callClient")
    public String callClientTest(){
        String url = "http://client-service/clientTest";
        String result = restTemplate.getForObject(url,String.class);
        return result;
    }
}
