package pers.guzx.gatewayservice.utils;

import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;

import java.util.List;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/5/11 18:09
 * @describe
 */
public class IpUtils {

    public static String getIpAddr(ServerHttpRequest request) {
        HttpHeaders headers = request.getHeaders();
        List<String> ips = headers.get("X-Forwarded-For");
        String ip = "";
        if (ips != null && ips.size() > 0) {
            ip = ips.get(0);
        }
        return ip;
    }
}
