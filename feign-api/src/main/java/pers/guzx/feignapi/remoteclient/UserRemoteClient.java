package pers.guzx.feignapi.remoteclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import pers.guzx.feignapi.pojo.UserInfo;

import java.util.Map;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/6 11:30
 * @describe
 */
@FeignClient("feign-provide")
public interface UserRemoteClient {

    @GetMapping("/feign/getData")
    String getData();

    @GetMapping("/feign/getUserInfo")
    String getUserInfo(@RequestParam("name") String name, @RequestParam("age") int age);

    @GetMapping("/feign/getUserDetail")
    String getUserDetail(@RequestParam Map<String, Object> param);

    @GetMapping("/feign/getUser/{userId}")
    String getUser(@PathVariable("userId") int userId);

    @PostMapping("/feign/addUser")
    UserInfo addUser(@RequestBody UserInfo userInfo);
}
