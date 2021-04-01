package pers.guzx.consumerservice.config;

import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;
import pers.guzx.consumerservice.annotation.MyLoadBalanced;
import pers.guzx.consumerservice.intercept.LoadBalanceInterceptor;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/1 16:20
 * @describe
 */
@Configuration
public class MyLoadBalanceAutoConfiguration {

    @MyLoadBalanced
    @Resource
    private List<RestTemplate> restTemplates = Collections.emptyList();

    @Resource
    private LoadBalancerClient loadBalancerClient;

    @Bean
    public LoadBalanceInterceptor loadBalanceInterceptor() {
        return new LoadBalanceInterceptor(loadBalancerClient);
    }

    @Bean
    public SmartInitializingSingleton myLoadBalanceRestTemplateInitializer() {
        return new SmartInitializingSingleton() {
            @Override
            public void afterSingletonsInstantiated() {
                for (RestTemplate restTemplate : MyLoadBalanceAutoConfiguration.this.restTemplates) {
                    List<ClientHttpRequestInterceptor> list = new ArrayList<>(restTemplate.getInterceptors());
                    list.add(loadBalanceInterceptor());
                    restTemplate.setInterceptors(list);
                }
            }
        };
    }
}
