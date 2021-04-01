package pers.guzx.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.guzx.web.client.CustomClient;
import pers.guzx.web.properties.CustomPropertiesConfig;

import javax.annotation.Resource;

/**
 * @since:2021年3月29日 下午7:13:40 
 * @author:Administrator 
 * @apiNote:测试controller
 */
@RestController
@Slf4j
public class Demo1 {

	@Resource
	private Environment env;

	@Value("${user.age}")
	private int age;

	@Resource
	private CustomPropertiesConfig config;

	@GetMapping("/demo")
	public String demo() {
		System.out.println("user age" + age);
		System.out.println("user addr" + env.getProperty("user.addr"));
		System.out.println("user sex" + config.getSex());
		System.out.println(System.getProperties());
		log.trace("测试热部署");
		return "demo";
	}

	@Autowired
	private CustomClient customClient;

	@GetMapping("/custom")
	public String customStarter(){
		return customClient.getName();
	}
}
