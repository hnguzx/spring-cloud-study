package pers.guzx.zuulserver2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class ZuulServer2Application {

    public static void main(String[] args) {
        SpringApplication.run(ZuulServer2Application.class, args);
    }

}
