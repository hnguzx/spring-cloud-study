package pers.guzx.clientservice.config;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.sleuth.instrument.async.LazyTraceExecutor;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.annotation.Resource;
import java.util.concurrent.Executor;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/6/29 15:33
 * @describe
 */
@Configuration
@EnableAutoConfiguration
public class CustomExecutorConfig extends AsyncConfigurerSupport {

    @Resource
    private BeanFactory beanFactory;

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(7);
        taskExecutor.setMaxPoolSize(42);
        taskExecutor.setQueueCapacity(11);
        taskExecutor.setThreadNamePrefix("guzx-");
        taskExecutor.initialize();
        return new LazyTraceExecutor(this.beanFactory, taskExecutor);
    }
}
