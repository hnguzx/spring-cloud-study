package pers.guzx.consumerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import pers.guzx.consumerservice.config.RibbonConfig;

//@RibbonClients(defaultConfiguration = RibbonConfig.class)
@SpringBootApplication
@EnableDiscoveryClient
@RibbonClient(name = "client-service",configuration = RibbonConfig.class)
@EnableFeignClients
public class ConsumerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerServiceApplication.class, args);
    }

}
