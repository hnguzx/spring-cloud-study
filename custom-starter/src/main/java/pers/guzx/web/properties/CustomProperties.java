package pers.guzx.web.properties;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/3/30 11:48
 * @describe 用于在属性文件中的配置值，相当于spring.data.mongo
 */
@ConfigurationProperties(prefix = "custom")
@Getter
@Setter
public class CustomProperties {
    private String name;
}
