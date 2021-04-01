package pers.guzx.web.pojo;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @since:2021年3月29日 下午3:48:23
 * @author:Administrator
 * @apiNote:系统统一返回数据
 */
@Component
@Getter
@Setter
@Accessors(chain = true)
public class ApiResp<T> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
     * 响应码
     */
    private int code = 200;

    /**
     * 响应信息
     */
    private String msg = "";
	
	/**
     * 响应内容，默认为null
     */
    private T data = null;

}
