package pers.guzx.web.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pers.guzx.web.client.CustomClient;
import pers.guzx.web.properties.CustomProperties;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/3/30 15:37
 * @describe 自动构建CustomClient
 */
@Configuration
@EnableConfigurationProperties(CustomProperties.class)
public class CustomAutoConfig {

    @Bean
    @ConditionalOnProperty(prefix = "custom", value = "enable", havingValue = "true")
    public CustomClient customClient(CustomProperties customProperties) {
        return new CustomClient(customProperties);
    }
}
