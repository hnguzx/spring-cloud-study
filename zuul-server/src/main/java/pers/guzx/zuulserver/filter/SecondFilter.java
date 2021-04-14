package pers.guzx.zuulserver.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/14 15:40
 * @describe
 */
@Slf4j
public class SecondFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 2;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext context = RequestContext.getCurrentContext();
        Object isSuccess = context.get("isSuccess");
        return isSuccess==null?true:Boolean.parseBoolean(isSuccess.toString());
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        Object msg = context.get("msg");
        log.info("第二个过滤器收到的信息："+msg);
        return null;
    }
}
