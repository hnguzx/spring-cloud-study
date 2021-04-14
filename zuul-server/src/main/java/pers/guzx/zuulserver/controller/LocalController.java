package pers.guzx.zuulserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/14 11:29
 * @describe
 */
@RestController
@RequestMapping("/local")
public class LocalController {

    @GetMapping("/{id}")
    public String local(@PathVariable("id") String id) {
        return "接收到的ID是：" + id;
    }
}
