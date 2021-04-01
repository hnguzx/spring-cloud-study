package pers.guzx.web.handle;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health.Builder;
import org.springframework.stereotype.Component;

/**
 * @since:2021年3月29日 下午3:38:10
 * @author:Administrator
 * @apiNote:系统健康指标扩展
 */
@Component
public class CustomHealthHandler extends AbstractHealthIndicator{

	@Override
	protected void doHealthCheck(Builder builder) throws Exception {
		builder.up().withDetail("code", 200);
//		builder.down().withDetail("code", 500);
	}

}
