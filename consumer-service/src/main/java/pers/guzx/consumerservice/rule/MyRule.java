package pers.guzx.consumerservice.rule;

//import com.netflix.client.config.IClientConfig;
//import com.netflix.loadbalancer.*;
//import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/2 10:00
 * @describe
 */
//@Slf4j
/*public class MyRule extends AbstractLoadBalancerRule {

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    @Override
    public Server choose(Object key) {
        return this.choose(this.getLoadBalancer(),key);
    }

    public Server choose(ILoadBalancer iLoadBalancer, Object key) {
        // 无法获取到所有的服务，自定义校验规则还有问题
        List<Server> allServers = iLoadBalancer.getAllServers();
        log.info("进入了！");
        return null;
    }
}*/
