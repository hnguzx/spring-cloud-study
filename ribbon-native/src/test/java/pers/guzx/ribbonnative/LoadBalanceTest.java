package pers.guzx.ribbonnative;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.LoadBalancerBuilder;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.reactive.LoadBalancerCommand;
import com.netflix.loadbalancer.reactive.ServerOperation;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import rx.Observable;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/1 11:29
 * @describe
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class LoadBalanceTest {

    @Test
    public void testLoadBalance() {
        List<Server> serverList = Lists.newArrayList(
                new Server("localhost", 4567),
                new Server("localhost", 4568));

        ILoadBalancer loadBalancer = LoadBalancerBuilder.newBuilder()
                .buildFixedServerListLoadBalancer(serverList);

        for (int i = 0; i < 20; i++) {
            String result = LoadBalancerCommand.<String>builder()
                    .withLoadBalancer(loadBalancer)
                    .build()
                    .submit(new ServerOperation<String>() {
                        @Override
                        public Observable<String> call(Server server) {
                            String addr = "http://" + server.getHost() + ":" + server.getPort() + "/clientTest";
                            log.info("调用地址：" + addr);
                            URL url = null;
                            try {
                                url = new URL(addr);
                                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                                connection.setRequestMethod("GET");
                                connection.connect();
                                InputStream inputStream = connection.getInputStream();
                                byte[] data = new byte[inputStream.available()];
                                inputStream.read(data);
                                return Observable.just(new String(data));
                            } catch (Exception e) {
                                e.printStackTrace();
                                return Observable.error(e);
                            }
                        }
                    }).toBlocking().first();
            log.info("调用结果：" + result);
        }
    }
}
