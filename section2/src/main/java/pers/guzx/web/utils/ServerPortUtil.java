package pers.guzx.web.utils;

import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Random;


/**
 * @since:2021年3月30日 上午10:17:03
 * @author:Administrator
 * @apiNote:获取可用端口
 */
@Component
public class ServerPortUtil implements ApplicationListener<WebServerInitializedEvent> {

    private int serverPort;

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

    public int getCurrentPort() {
        return this.serverPort;
    }

    @Override
    public void onApplicationEvent(WebServerInitializedEvent event) {
        this.serverPort = event.getWebServer().getPort();
    }
}
