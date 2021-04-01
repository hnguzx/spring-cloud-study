package pers.guzx.web.endpoint;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @since:2021年3月29日 下午3:38:10
 * @author:Administrator
 * @apiNote:自定义系统监测端点
 */
@Component
@Endpoint(id = "user")
public class UserEndpoint {
	
	@ReadOperation
	public List<Map<String, Object>> health(){
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		Map<String, Object> map = new HashMap<String, Object>(5);
		map.put("name", "guzx");
		map.put("age", 24);
		list.add(map);
		return list;
	}
}
