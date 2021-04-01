package pers.guzx.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import pers.guzx.web.properties.CustomProperties;

@SpringBootApplication
public class CustomStarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomStarterApplication.class, args);
    }

}
