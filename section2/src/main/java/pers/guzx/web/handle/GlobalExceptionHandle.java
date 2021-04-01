package pers.guzx.web.handle;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;
import pers.guzx.web.pojo.ApiResp;
import pers.guzx.web.task.LogTask;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @since:2021年3月29日 下午3:45:05 
 * @author:Administrator 
 * @apiNote:全局异常处理
 */
@ControllerAdvice
public class GlobalExceptionHandle {

	@Resource
	private ApiResp<Object> apiResp;
	
	@Resource
	private LogTask log;

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public ApiResp<Object> defaultErrorHandle(HttpServletRequest request, Exception exception) {
		log.saveError(exception.getMessage());
		apiResp.setMsg(exception.getMessage());
		if (exception instanceof NoHandlerFoundException) {
			apiResp.setCode(404);
		} else {
			apiResp.setCode(500);
		}
		apiResp.setData(null);
		return apiResp;
	}
}
