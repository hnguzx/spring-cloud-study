package pers.guzx.feignconsume;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"pers.guzx.feignapi"})
@SpringBootApplication
public class FeignConsumeApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignConsumeApplication.class, args);
    }

}
