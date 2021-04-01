package pers.guzx.web.config;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @since:2021年3月29日 下午4:17:21
 * @author:Administrator
 * @apiNote:异步线程池参数设置
 */
@ConfigurationProperties(prefix = "spring.task.pool")
@Configuration
@Getter
@Setter
@Accessors(chain = true)
public class TaskThreadPoolConfig {
	private int corePoolSize = 5;
	private int maxPoolSize = 50;
	private int keepAliveSeconds = 60;
	private int queueCapacity = 10000;
	private String threadNamePrefix = "GZX-AsyncTask-";
}
