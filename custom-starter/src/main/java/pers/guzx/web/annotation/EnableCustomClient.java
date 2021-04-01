package pers.guzx.web.annotation;

import org.springframework.context.annotation.Import;
import pers.guzx.web.config.CustomAutoConfig;

import java.lang.annotation.*;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/3/30 16:23
 * @describe
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({CustomAutoConfig.class})
public @interface EnableCustomClient {
}
