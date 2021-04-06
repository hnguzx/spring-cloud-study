package pers.guzx.feignprovide.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.guzx.feignapi.pojo.UserInfo;
import pers.guzx.feignapi.remoteclient.UserRemoteClient;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/6 11:33
 * @describe
 */
@RestController
@Slf4j
public class FeignController implements UserRemoteClient {

    @Override
    public String getData() {
        return "这个服务的提供者";
    }

    @Override
    public String getUserInfo(String name, int age) {
        log.info("收到的参数是：" + name + "和" + age);
        return "name:" + name + " age:" + age;
    }

    @Override
    public String getUserDetail(Map<String, Object> param) {
        for (Map.Entry<String, Object> entry : param.entrySet()) {
            log.info("Key=" + entry.getKey() + " Value" + entry.getValue());
        }
        log.info("传到这的参数有：" + param.size());
        return "调用成功";
    }

    @Override
    public String getUser(int userId) {
        log.info("要查询的用户id是：" + userId);
        return "查询用户成功";
    }

    @Override
    public UserInfo addUser(@RequestBody UserInfo userInfo) {
        log.info(userInfo.getName() + "---" + userInfo.getAge() + "---" + userInfo.getAddr());
        return userInfo;
    }

}
