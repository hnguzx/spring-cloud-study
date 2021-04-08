package pers.guzx.hystrixfeign.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import pers.guzx.hystrixfeign.client.CustomConsumerRemoteClient;
import pers.guzx.hystrixfeign.client.CustomRemoteClient;

import javax.annotation.Resource;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/7 17:52
 * @describe
 */
@RestController
@RequestMapping("/call")
@Slf4j
public class HystrixController {

    @Resource
    private RestTemplate template;

    @HystrixCommand(fallbackMethod = "defaultCallFail")
    @GetMapping("/hystrix")
    public String callClient() {
        // 这种方式调用会需要登录校验，且登录后无法正常返回数据
        String url = "http://client-service/clientTest";
        String result = template.getForObject(url, String.class);
        return result;
    }

    @Resource
    private CustomRemoteClient client;

    @Resource
    private CustomConsumerRemoteClient customConsumerRemoteClient;

    /*@HystrixCommand(fallbackMethod = "defaultCallFail",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.strategy", value = "THREAD"),
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000")
            })*/
    @GetMapping("/hystrixRemoteClient")
    public String remoteClient() {
        String result = client.clientTest();
        log.info("服务端调用结果：" + result);
        String result2 = customConsumerRemoteClient.callConsumer();
        log.info("消费端调用结果：" + result2);
        return result + "---" + result2;
    }

    public String defaultCallFail() {
        return "调用失败，默认处理结果";
    }
}
