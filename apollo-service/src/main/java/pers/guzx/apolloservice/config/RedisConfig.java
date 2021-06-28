package pers.guzx.apolloservice.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/6/23 14:00
 * @describe
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "redis.cache")
public class RedisConfig {
    private String host;
}
