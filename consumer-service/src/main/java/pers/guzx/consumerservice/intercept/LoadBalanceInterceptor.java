package pers.guzx.consumerservice.intercept;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerRequestFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.io.IOException;
import java.net.URI;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/1 16:03
 * @describe
 */
@Slf4j
public class LoadBalanceInterceptor implements ClientHttpRequestInterceptor {
    private LoadBalancerClient loadBalancerClient;
    private LoadBalancerRequestFactory loadBalancerRequestFactory;

    public LoadBalanceInterceptor(LoadBalancerClient loadBalancerClient, LoadBalancerRequestFactory loadBalancerRequestFactory) {
        this.loadBalancerClient = loadBalancerClient;
        this.loadBalancerRequestFactory = loadBalancerRequestFactory;
    }

    public LoadBalanceInterceptor(LoadBalancerClient loadBalancerClient) {
        this(loadBalancerClient, new LoadBalancerRequestFactory(loadBalancerClient));
    }

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        final URI originalUri = request.getURI();
        String serviceName = originalUri.getHost();
        log.info("进入自定义的拦截器中" + serviceName);
        Assert.state(serviceName != null, "Request URI does not contain a valid hostname:" + originalUri);
        return this.loadBalancerClient.execute(serviceName, loadBalancerRequestFactory.createRequest(request, body, execution));
    }
}
