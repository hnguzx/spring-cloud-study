package pers.guzx.zuulserver.fallback;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import pers.guzx.zuulserver.base.ResponseCode;
import pers.guzx.zuulserver.base.ResponseData;
import pers.guzx.zuulserver.util.JsonUtils;

/**
 * @author Administrator
 */
@Component
public class ServiceConsumerFallbackProvider implements FallbackProvider {
	
	private Logger log = LoggerFactory.getLogger(ServiceConsumerFallbackProvider.class);

	@Override
	public String getRoute() {
		// 对指定的服务进行回退，*表示所有服务，特定服务则返回服务名称
		return "*";
	}

	@Override
	public ClientHttpResponse fallbackResponse(String route, Throwable cause) {

		// 构造回退的内容
		return new ClientHttpResponse() {
			@Override
			public HttpStatus getStatusCode() throws IOException {
				return HttpStatus.OK;
			}

			@Override
			public int getRawStatusCode() throws IOException {
				return this.getStatusCode().value();
			}

			@Override
			public String getStatusText() throws IOException {
				return this.getStatusCode().getReasonPhrase();
			}

			@Override
			public void close() {

			}

			@Override
			public InputStream getBody() throws IOException {
				if (cause != null) {
					log.error("", cause.getCause());
				}
				ResponseData data = ResponseData.fail(route+"服务内部错误", ResponseCode.SERVER_ERROR_CODE.getCode());
				return new ByteArrayInputStream(JsonUtils.toJson(data).getBytes());
			}

			@Override
			public HttpHeaders getHeaders() {
				HttpHeaders headers = new HttpHeaders();
				MediaType mt = new MediaType("application", "json", Charset.forName("UTF-8"));
				headers.setContentType(mt);
				return headers;
			}
		};
	}
}
