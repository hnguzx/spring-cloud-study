package pers.guzx.consumerservice.client;

import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import pers.guzx.consumerservice.config.FeignConfig;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/6 10:29
 * @describe
 */
@FeignClient(value = "client-service",configuration = FeignConfig.class)
public interface CustomRemoteClient {

    @GetMapping("/clientTest")
    String clientTest();

    @GetMapping("/autoTask")
    String autoTask();
}
