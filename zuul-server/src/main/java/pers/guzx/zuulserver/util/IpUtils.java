package pers.guzx.zuulserver.util;

import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class IpUtils implements ApplicationListener<WebServerInitializedEvent> {

	private int serverPort;

	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-real-ip");

		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("x-forwarded-for");
			if (ip != null) {
				ip = ip.split(",")[0].trim();
			}
		}

		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}

		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}

		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}

		return ip;
	}

	public int getCurrentPort() {
		return this.serverPort;
	}

	@Override
	public void onApplicationEvent(WebServerInitializedEvent webServerInitializedEvent) {
		this.serverPort = webServerInitializedEvent.getWebServer().getPort();
	}
}
