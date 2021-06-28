package pers.guzx.apolloservice.controller;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.core.spi.MetaServerProvider;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import com.ctrip.framework.apollo.spring.annotation.ApolloJsonValue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.guzx.apolloservice.config.RedisConfig;
import pers.guzx.apolloservice.config.UserConfig;
import pers.guzx.apolloservice.pojo.Student;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/6/23 11:52
 * @describe
 */
@RestController
public class ConfigController {

    @Value("${guzx:guzhixiong}")
    private String guzx;

    @GetMapping("/config/getUserName")
    public String getUserName() {
        return guzx;
    }

    @Resource
    private UserConfig userConfig;

    @GetMapping("/config/getSex")
    public String getUserSex() {
        return userConfig.getSex();
    }

    @Resource
    private RedisConfig redisConfig;

    @GetMapping("/config/getHost")
    public String getHost() {
        return redisConfig.getHost();
    }

    @ApolloConfigChangeListener
    private void someOnChange(ConfigChangeEvent changeEvent) {
        if(changeEvent.isChanged("host")) {
            System.out.println("host发生修改了");
            redisConfig.setHost(changeEvent.getChange("host").getNewValue());
        }
    }

    @ApolloConfig
    private Config config;

    @GetMapping("/config/getAddr")
    public String getAddr() {
        return config.getProperty("addr","sz");
    }

    @ApolloJsonValue("${students:[]}")
    private List<Student> students;

    @GetMapping("/config/getStus")
    private List<Student> getStudents(){
        return students;
    }
}
