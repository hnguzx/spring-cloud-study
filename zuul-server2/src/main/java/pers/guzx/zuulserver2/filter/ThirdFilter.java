package pers.guzx.zuulserver2.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/14 15:54
 * @describe
 */
@Slf4j
public class ThirdFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "route";
    }

    @Override
    public int filterOrder() {
        return 3;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        log.info("route过滤器执行了");
//        System.out.println(2/0);
        return null;
    }
}
