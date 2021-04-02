package pers.guzx.consumerservice.config;

import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import pers.guzx.consumerservice.annotation.MyLoadBalanced;

import java.util.Collections;
import java.util.List;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/3/31 10:42
 * @describe
 */
@Configuration
public class BeanConfig {

    @Bean
    @LoadBalanced
//    @MyLoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }


}
