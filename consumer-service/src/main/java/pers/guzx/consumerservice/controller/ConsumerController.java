package pers.guzx.consumerservice.controller;

import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class ConsumerController {

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/callClient")
    public String callClientTest(){
        String url = "http://client-service/clientTest";
        String result = restTemplate.getForObject(url,String.class);
        return result;
    }

    @GetMapping("/celled")
    public String called(){
        log.info("消费者被call了");
        return "消费者被call成功了";
    }
}
