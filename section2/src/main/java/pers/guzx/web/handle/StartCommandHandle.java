package pers.guzx.web.handle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import pers.guzx.web.utils.ServerPortUtil;

/**
 * @since:2021年3月30日 上午10:12:25
 * @author:Administrator
 * @apiNote:设置启动端口
 */
@Slf4j
public class StartCommandHandle {
	public StartCommandHandle(String[] args) {
		Boolean isServerPort = false;
		String serverPort = "";
		if (args != null) {
			for (String arg : args) {
				if (StringUtils.hasText(arg) && arg.startsWith("--server.port")) {
					isServerPort = true;
					serverPort = arg;
					break;
				}
			}
		}

		if (!isServerPort) {
			int port = ServerPortUtil.getAvailablePort();
			log.info("current server.port=" + port);
			System.setProperty("server.port", String.valueOf(port));
		} else {
			log.info("current server.port=" + serverPort.split("=")[1]);
			System.setProperty("server.port", serverPort.split("=")[1]);
		}

	}
}
