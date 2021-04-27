package pers.guzx.zuulserver2.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import io.micrometer.core.instrument.util.IOUtils;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/25 19:37
 * @describe
 */
public class ResponseFile extends ZuulFilter {
    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        // 获取请求信息
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        System.err.println("REQUEST::>" + request.getScheme() + "  " + request.getRemoteAddr() + ":" + request.getRemotePort());
        StringBuilder params = new StringBuilder("?");
        Enumeration<String> names = request.getParameterNames();
        if (request.getMethod().equals("GET")) {
            while (names.hasMoreElements()) {
                String name = names.nextElement();
                params.append(name);
                params.append("=");
                params.append(request.getParameter(name));
                params.append("&");
            }
        }
        if (params.length() > 0) {
            params.delete(params.length() - 1, params.length());
        }
        System.err.println("REQUEST::>" + request.getMethod() + "  " + request.getRequestURI() + params + "  " + request.getProtocol());
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            String value = request.getHeader(name);
            System.err.println("REQUEST::>" + name + ":" + value);
        }
        final RequestContext currentContext = RequestContext.getCurrentContext();
        if (!currentContext.isChunkedRequestBody()) {
            ServletInputStream servletInputStream = null;
            try {
                servletInputStream = currentContext.getRequest().getInputStream();
                String body = null;
                if (servletInputStream != null) {
                    body = IOUtils.toString(servletInputStream);
                    System.err.println("REQUEST::>" + body);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // 获取响应信息
        /*Object zuulResponse = currentContext.get("zuulResponse");
        if (zuulResponse != null) {
            RibbonHttpResponse response = (RibbonHttpResponse) zuulResponse;
            try {
                String body = IOUtils.toString(response.getBody());
                System.err.println("RESPONSE::>" + body);
                response.close();
                currentContext.setResponseBody(body);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
        InputStream responseDataStream = currentContext.getResponseDataStream();
        if (responseDataStream != null) {
            String body = IOUtils.toString(responseDataStream);
            System.err.println("RESPONSE::>" + body);
            currentContext.setResponseBody(body);
        }
        return null;
    }
}
