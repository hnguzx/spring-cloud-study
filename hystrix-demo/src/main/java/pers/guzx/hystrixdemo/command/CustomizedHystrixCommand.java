package pers.guzx.hystrixdemo.command;

import com.netflix.hystrix.*;
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategy;
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategyDefault;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/7 15:54
 * @describe
 */
public class CustomizedHystrixCommand extends HystrixCommand<String> {
    private final String name;

    public static final HystrixCommandKey GETTER_KEY = HystrixCommandKey.Factory.asKey("MyCacheGroup");

    protected CustomizedHystrixCommand(String name) {
        // 线程隔离
        /*super(HystrixCommandGroupKey.Factory.asKey("MyGroup"));*/
        // 信号量隔离
        /*super(HystrixCommand.Setter.withGroupKey((HystrixCommandGroupKey.Factory.asKey("MyGroup"))).
                        andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withExecutionIsolationStrategy(
//                        HystrixCommandProperties.ExecutionIsolationStrategy.SEMAPHORE
                                HystrixCommandProperties.ExecutionIsolationStrategy.THREAD
                                )
                        ).andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter().
                        withCoreSize(10).
                        withMaxQueueSize(100).
                        withMaximumSize(100)
                )
        );*/
        super(HystrixCommand.Setter.withGroupKey(
                HystrixCommandGroupKey.Factory.asKey("MyCacheGroup")).
                andCommandKey(GETTER_KEY));
        this.name = name;
    }

    @Override
    protected String run() throws Exception {
//        Thread.sleep(100000);
        System.err.println("get data");
        return this.name + ":" + Thread.currentThread().getName();
    }

    @Override
    protected String getFallback() {
        return "调用失败了";
    }

    @Override
    protected String getCacheKey() {
        return String.valueOf(this.name);
    }

    public static void flushCache(String name) {
        HystrixRequestCache.getInstance(GETTER_KEY, HystrixConcurrencyStrategyDefault.getInstance()).clear(name);
    }
}
