package pers.guzx.web.task;

/**
 * @Since:2021年3月29日 下午4:22:05
 * @author:Administrator
 * @apiNote:处理日志相关
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class LogTask {

	@Async
	public void saveDebug(String message) {
		log.debug(message);
	}

	@Async
	public void saveInfo(String message) {
		log.info(message);
	}

	@Async
	public void saveWarn(String message) {
		log.warn(message);
	}

	@Async
	public void saveError(String message) {
		log.error(message);
	}
}
