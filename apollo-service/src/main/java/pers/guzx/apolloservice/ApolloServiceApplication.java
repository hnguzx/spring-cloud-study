package pers.guzx.apolloservice;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pers.guzx.apolloservice.config.UserConfig;

import javax.annotation.Resource;

@SpringBootApplication
public class ApolloServiceApplication {

    @Resource
    private UserConfig userConfig;

    public static void main(String[] args) {
        System.setProperty("env", "DEV");
        SpringApplication.run(ApolloServiceApplication.class, args);
    }

}
