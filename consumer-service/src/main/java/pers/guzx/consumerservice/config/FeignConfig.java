package pers.guzx.consumerservice.config;

import feign.Contract;
import feign.Logger;
import feign.Request;
import feign.Retryer;
import feign.auth.BasicAuthRequestInterceptor;
import feign.codec.Decoder;
import feign.codec.Encoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/6 10:41
 * @describe
 */
@Configuration
public class FeignConfig {

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor("client", "111111");
    }

    @Bean
    public Request.Options options() {
        return new Request.Options(5, TimeUnit.SECONDS, 10, TimeUnit.SECONDS, true);
    }

//    @Bean
    public Decoder decoder() {
        return new Decoder.Default();
    }

//    @Bean
    public Encoder encoder() {
        return new Encoder.Default();
    }

//    @Bean
    public Retryer retryer(){
        return new Retryer.Default();
    }

//    @Bean
    public Contract contract(){
        return new Contract.Default();
    }
}
