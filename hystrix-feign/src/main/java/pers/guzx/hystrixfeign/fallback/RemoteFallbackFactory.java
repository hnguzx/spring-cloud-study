package pers.guzx.hystrixfeign.fallback;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;
import pers.guzx.hystrixfeign.client.CustomRemoteClient;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/8 15:42
 * @describe 对回退进行处理
 */
@Component
@Slf4j
public class RemoteFallbackFactory implements FallbackFactory<CustomRemoteClient> {
    @Override
    public CustomRemoteClient create(Throwable cause) {
        log.error("CustomRemoteClient error:", cause);
        return new CustomRemoteClient() {
            @Override
            public String clientTest() {
                return "这是通过fallbackFactory进行处理后的返回";
            }
        };
    }
}
