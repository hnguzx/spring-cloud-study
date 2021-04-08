package pers.guzx.hystrixfeign.fallback;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pers.guzx.hystrixfeign.client.CustomRemoteClient;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/8 14:24
 * @describe 调用失败时进行处理
 */
@Component
@Slf4j
public class RemoteClientFallback implements CustomRemoteClient {
    @Override
    public String clientTest() {
        log.info("进入fallback");
        return "这是通过实现client接口的失败回退处理";
    }
}
