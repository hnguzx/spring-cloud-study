package pers.guzx.consumerservice.config;

import com.netflix.loadbalancer.BestAvailableRule;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import pers.guzx.consumerservice.annotation.MyLoadBalanced;

import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/3/31 10:42
 * @describe
 */
@Configuration
public class RibbonConfig {

    // 负载均衡
    @Bean
    @LoadBalanced
//    @MyLoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }


    @Bean
    public IRule rule(){
        return new BestAvailableRule();
    }
}
