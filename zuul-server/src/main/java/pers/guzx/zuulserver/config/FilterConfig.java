package pers.guzx.zuulserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pers.guzx.zuulserver.filter.ErrorFilter;
import pers.guzx.zuulserver.filter.IpFilter;
import pers.guzx.zuulserver.filter.SecondFilter;
import pers.guzx.zuulserver.filter.ThirdFilter;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/14 14:01
 * @describe
 */
@Configuration
public class FilterConfig {

    @Bean
    public IpFilter ipFilter() {
        return new IpFilter();
    }

    @Bean
    public SecondFilter secondFilter(){
        return new SecondFilter();
    }

    @Bean
    public ThirdFilter thirdFilter(){
        return new ThirdFilter();
    }

    @Bean
    public ErrorFilter errorFilter(){
        return new ErrorFilter();
    }
}
