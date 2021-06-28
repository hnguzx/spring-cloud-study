package pers.guzx.apolloservice.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/6/21 17:01
 * @describe
 */
@Data
@Configuration
public class UserConfig {

    @Value("${sex:none}")
    private String sex;
}
