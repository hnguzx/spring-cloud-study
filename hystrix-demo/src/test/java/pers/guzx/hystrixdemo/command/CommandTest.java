package pers.guzx.hystrixdemo.command;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/7 15:58
 * @describe
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class CommandTest {

    @Test
    public void testCommand() {
        System.out.println("同步执行");
        String result = new CustomizedHystrixCommand("guzhixiong").execute();
        System.out.println(result);
    }

    @Test
    public void testAsyncCommand() throws ExecutionException, InterruptedException {
        System.out.println("异步执行");
        Future<String> result = new CustomizedHystrixCommand("guzhixiong").queue();
        System.out.println(result.get());
    }

    @Test
    public void testCache() throws ExecutionException, InterruptedException {
        HystrixRequestContext context = HystrixRequestContext.initializeContext();
        String result1 = new CustomizedHystrixCommand("lianghong").execute();
        System.out.println(result1);
        CustomizedHystrixCommand.flushCache("lianghong");
        Future<String> result2 = new CustomizedHystrixCommand("lianghong").queue();
        System.out.println(result2.get());

        context.shutdown();
    }
}
