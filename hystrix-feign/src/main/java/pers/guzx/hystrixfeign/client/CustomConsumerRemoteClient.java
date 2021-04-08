package pers.guzx.hystrixfeign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import pers.guzx.hystrixfeign.config.FeignConfig;
import pers.guzx.hystrixfeign.fallback.RemoteClientFallback;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/8 15:16
 * @describe
 */
@FeignClient(value = "consumer-service")
public interface CustomConsumerRemoteClient {

    @GetMapping("/celled")
    String callConsumer();
}
