package pers.guzx.web.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @since:2021年3月30日 上午9:29:08
 * @author:Administrator
 * @apiNote:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class ServiceTest {
	
	@Test
	public void logTest() {
		String msg = "log=======";
		log.trace(msg);
		log.debug(msg);
		log.info(msg);
		log.warn(msg);
		log.error(msg);
	}
}
