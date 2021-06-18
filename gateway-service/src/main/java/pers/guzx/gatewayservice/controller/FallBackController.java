package pers.guzx.gatewayservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/6/18 14:52
 * @describe
 */
@RestController
public class FallBackController {

    @GetMapping("/fallback")
    public String fallback() {
        return "fallback";
    }
}
