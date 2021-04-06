package pers.guzx.consumerservice.intercept;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.http.HttpHeaders;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/6 10:49
 * @describe feign自定义认证
 */
public class FeignBasicAuthRequestInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
//        requestTemplate.header("","");
    }
}
