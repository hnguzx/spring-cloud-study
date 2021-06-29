package pers.guzx.clientservice.controller;

import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.guzx.clientservice.async.CustomTask;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/3/31 9:54
 * @describe
 */
@RestController
public class ClientController {

    @GetMapping("/clientTest")
    public String clientTest(){
        return "client connect success!";
    }

    @GetMapping("/addHead")
    public String addRequestHead(HttpServletRequest request) {
        System.err.println(request.getHeader("X-Request-Foo"));
        return "success";
    }

    @Resource
    private CustomTask task;

    @GetMapping("/autoTask")
    public String autoTask() throws InterruptedException {
        task.runAutoTask();
        task.newSpan();
        return "success";
    }

    @Resource
    private EurekaClient eurekaClient;

    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${spring.application.name}")
    private String instanceName;

    @GetMapping("/eurekaData")
    public Object getEurekaDataByEurekaClient(){
        return eurekaClient.getInstancesByVipAddress(instanceName,false);
    }

    @GetMapping("/discoveryData")
    public Object getEurekaDataByDiscoveryClient(){
        return discoveryClient.getInstances(instanceName);
    }
}
