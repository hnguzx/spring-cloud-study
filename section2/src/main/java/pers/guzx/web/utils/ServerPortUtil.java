package pers.guzx.web.utils;

import java.util.Random;


/**
 * @since:2021年3月30日 上午10:17:03
 * @author:Administrator
 * @apiNote:获取可用端口
 */
public class ServerPortUtil {

	public static int getAvailablePort() {
		int max = 65535;
		int min = 2000;

		Random random = new Random();
		int port = random.nextInt(max) % (max - min + 1) + min;
		boolean using = NetUtils.isLoclePortUsing(port);
		if (using) {
			return getAvailablePort();
		} else {
			return port;
		}
	}
}
