package pers.guzx.web.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @since:2021年3月30日 上午10:43:51
 * @author:Administrator
 * @apiNote:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ServerPortUtilTest {

	@Test
	public void serverPortTest() {
		boolean isUsing = NetUtils.isLoclePortUsing(30000);
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println(isUsing);
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
	}
}
