package pers.guzx.gatewayservice.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pers.guzx.gatewayservice.utils.IpUtils;
import reactor.core.publisher.Mono;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/5/11 18:05
 * @describe
 */
@Configuration
public class IPConfig {

    /**
     * ip限流
     *
     * @return
     */
    @Bean
    public KeyResolver ipKeyResolver() {
        return exchange -> {
            return Mono.just(exchange.getRequest().getRemoteAddress().getHostName());
        };
    }

    /**
     * 用户限流
     *
     * @return
     */
    @Bean
    public KeyResolver userKeyResolver() {
        return exchange -> {
            return Mono.just(exchange.getRequest().getQueryParams().getFirst("userId"));
        };
    }

    /**
     * 接口限流
     *
     * @return
     */
    @Bean
    public KeyResolver apiKeyResolver() {
        return exchange -> {
            return Mono.just(exchange.getRequest().getPath().value());
        };
    }
}
