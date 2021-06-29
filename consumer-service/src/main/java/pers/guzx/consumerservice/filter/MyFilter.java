package pers.guzx.consumerservice.filter;

import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/6/29 15:52
 * @describe
 */
@Component
public class MyFilter extends GenericFilterBean {

    private final Tracer tracer;

    public MyFilter(Tracer tracer) {
        this.tracer = tracer;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        Span span = this.tracer.currentSpan();
        if (span == null) {
            chain.doFilter(request, response);
            return;
        }
        ((HttpServletResponse) response).addHeader("ZIPKIN-TRACE-ID", span.context().traceId());
        span.tag("custom", "tag");
        chain.doFilter(request, response);
    }
}
