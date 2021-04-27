package pers.guzx.zuulserver2.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import pers.guzx.zuulserver2.base.ResponseCode;
import pers.guzx.zuulserver2.base.ResponseData;
import pers.guzx.zuulserver2.util.IpUtils;
import pers.guzx.zuulserver2.util.JsonUtils;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/14 11:49
 * @describe
 */
@Slf4j
public class IpFilter extends ZuulFilter {
    private List<String> blackIpList = Arrays.asList("127.0.0.1");

    public IpFilter(){
        super();
    }

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Resource
    private IpUtils utils;

    @Override
    public boolean shouldFilter() {
        RequestContext context = RequestContext.getCurrentContext();
        log.info("尝试在这里获取信息");
        System.out.println("当前系统的端口号：" + utils.getCurrentPort());
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        String ip = IpUtils.getIpAddr(context.getRequest());
        if (StringUtils.isNotBlank(ip) && blackIpList.contains(ip)){
            context.setSendZuulResponse(false);
            // 拦截本地转发请求的，但是好像不生效？
            context.set("sendForwardFilter.ran",true);
            // 阻止后续的过滤器执行
            context.set("isSuccess",false);
            ResponseData data = ResponseData.fail("非法请求", ResponseCode.NO_AUTH_CODE.getCode());
            context.setResponseBody(JsonUtils.toJson(data));
            context.getResponse().setContentType("application/json;charset=utf-8");
            return null;
        }
        context.set("msg","这是从第一个过滤器中传过来的");
        return null;
    }
}
