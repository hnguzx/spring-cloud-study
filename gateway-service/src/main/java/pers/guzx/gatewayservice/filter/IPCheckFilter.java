package pers.guzx.gatewayservice.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import pers.guzx.gatewayservice.utils.IpUtils;
import reactor.core.publisher.Mono;

import java.net.InetAddress;
import java.net.InetSocketAddress;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/5/11 17:12
 * @describe 对ip地址进行检查
 */
@Component
public class IPCheckFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        if (getIp(request).equals("127.0.0.1")){
            ServerHttpResponse response = exchange.getResponse();
            System.out.println("禁止访问");
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }

    private String getIp(ServerHttpRequest request) {
//        String hostAddress = request.getRemoteAddress().getAddress().getHostAddress();
        String ipAddr = IpUtils.getIpAddr(request);
        return ipAddr;
    }
}
