package pers.guzx.gatewayservice.config;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.web.reactive.result.view.ViewResolver;
import pers.guzx.gatewayservice.handle.JsonExceptionHandle;

import java.util.Collections;
import java.util.List;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/6/18 17:31
 * @describe
 */
@Configuration
@EnableConfigurationProperties({ServerProperties.class, ResourceProperties.class})
public class ExceptionConfig {
    private final ServerProperties serverProperties;
    private final ApplicationContext applicationContext;
    private final ResourceProperties resourceProperties;
    private final List<ViewResolver> viewResolvers;
    private final ServerCodecConfigurer serverCodecConfigurer;

    public ExceptionConfig(ServerProperties serverProperties, ApplicationContext applicationContext,
                           ResourceProperties resourceProperties,
                           ObjectProvider<List<ViewResolver>> viewResolverProvider,
                           ServerCodecConfigurer serverCodecConfigurer) {
        this.serverProperties = serverProperties;
        this.applicationContext = applicationContext;
        this.resourceProperties = resourceProperties;
        this.viewResolvers = viewResolverProvider.getIfAvailable(Collections::emptyList);
        this.serverCodecConfigurer = serverCodecConfigurer;
    }

    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public ErrorWebExceptionHandler errorWebExceptionHandler(ErrorAttributes errorAttributes) {
        JsonExceptionHandle exceptionHandle = new JsonExceptionHandle(errorAttributes,
                this.resourceProperties,
                this.serverProperties.getError(),
                this.applicationContext);
        exceptionHandle.setViewResolvers(this.viewResolvers);
        exceptionHandle.setMessageWriters(this.serverCodecConfigurer.getWriters());
        exceptionHandle.setMessageReaders(this.serverCodecConfigurer.getReaders());
        return exceptionHandle;
    }
}
