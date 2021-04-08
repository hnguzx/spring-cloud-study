package pers.guzx.hystrixfeign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import pers.guzx.hystrixfeign.config.FeignConfig;
import pers.guzx.hystrixfeign.fallback.RemoteClientFallback;
import pers.guzx.hystrixfeign.fallback.RemoteFallbackFactory;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/6 10:29
 * @describe
 */
//@FeignClient(value = "client-service",configuration = FeignConfig.class,fallback = RemoteClientFallback.class)
@FeignClient(value = "client-service",configuration = FeignConfig.class,fallbackFactory = RemoteFallbackFactory.class)
public interface CustomRemoteClient {

    @GetMapping("/clientTest")
    String clientTest();
}
