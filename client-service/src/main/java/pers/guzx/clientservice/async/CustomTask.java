package pers.guzx.clientservice.async;

import org.springframework.cloud.sleuth.annotation.NewSpan;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/6/29 14:48
 * @describe
 */
@Component
public class CustomTask {

    @Async
    public void runAutoTask(){
        System.out.println("自动任务执行了");
    }

    @NewSpan("newSpan")
    public void newSpan() throws InterruptedException {
        Thread.sleep(2000);
    }
}
