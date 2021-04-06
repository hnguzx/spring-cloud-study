package pers.guzx.feignconsume.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.guzx.feignapi.pojo.UserInfo;
import pers.guzx.feignapi.remoteclient.UserRemoteClient;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/6 11:37
 * @describe
 */
@RestController
@RequestMapping("/call")
@Slf4j
public class CallFeignController {

    @Resource
    private UserRemoteClient userRemoteClient;

    @GetMapping("/remoteClient")
    public String callRemoteClient() {
        String result = userRemoteClient.getData();
        log.info("通过feign调用api实现接口调用，返回结果：" + result);
        return result;
    }

    @GetMapping("/userInfo")
    public String callRemoteGetUserInfo(@RequestParam("name") String name, @RequestParam("age") int age) {
        String result = userRemoteClient.getUserInfo(name, age);
        log.info("通过feign调用api实现接口调用，返回结果：" + result);
        return result;
    }

    @GetMapping("/userDetail")
    public String callRemoteGetUserDetail(@RequestParam Map<String, Object> param) {
        String result = userRemoteClient.getUserDetail(param);
        log.info("通过feign调用api实现接口调用，返回结果：" + result);
        return result;
    }

    @GetMapping("/user/{userId}")
    public String callRemoteGetUser(@PathVariable("userId") int userId) {
        String result = userRemoteClient.getUser(userId);
        log.info("通过feign调用api实现接口调用，返回结果：" + result);
        return result;
    }

    @PostMapping("/user")
    public Object callRemoteAddUser(@RequestBody UserInfo userInfo) {
        UserInfo user = userRemoteClient.addUser(userInfo);
        return user;
    }
}
