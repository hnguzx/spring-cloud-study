package pers.guzx.web.properties;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @since:2021年3月29日 下午7:13:40 
 * @author:Administrator 
 * @apiNote:属性文件读取配置
 */
@ConfigurationProperties(prefix = "user")
@Component
@Getter
@Setter
@Data
@Accessors(chain = true)
public class CustomPropertiesConfig {
	
	private String sex;
	
}
