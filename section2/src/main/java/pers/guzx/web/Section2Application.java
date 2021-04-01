package pers.guzx.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableAsync;
import pers.guzx.web.annotation.EnableCustomClient;
import pers.guzx.web.handle.StartCommandHandle;
import pers.guzx.web.properties.CustomPropertiesConfig;

/**
 * @since:2021年3月29日 下午7:13:40 
 * @author:Administrator 
 * @apiNote:启动文件
 */
@SpringBootApplication
@EnableAsync
@EnableCustomClient
public class Section2Application {

	public static void main(String[] args) {
//		new StartCommandHandle(args);
		SpringApplication.run(Section2Application.class, args);
	}

}
