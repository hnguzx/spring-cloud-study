package pers.guzx.web.utils;


import java.net.InetAddress;
import java.net.Socket;

/**
 * @since:2021年3月30日 上午10:17:03
 * @author:Administrator
 * @apiNote:
 */
public class NetUtils {
	
    public static boolean isLoclePortUsing(int port){
        boolean flag = true;
        try {
            flag = isPortUsing("127.0.0.1", port);
        } catch (Exception e) {
        }
        return flag;
    }
    
    public static boolean isPortUsing(String host,int port) {
        boolean flag = false;
        try {
            InetAddress theAddress = InetAddress.getByName(host);
            Socket socket = new Socket(theAddress,port);
            socket.close();
            flag = true;
        } catch (Exception e) {

        }
        return flag;
    }
    
}
