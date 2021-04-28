package pers.guzx.getaway.predicates;

import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.util.function.Predicate;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/28 18:21
 * @describe
 */
@Component
public class CheckAuthRoutePredicateFactory extends AbstractRoutePredicateFactory {
    public CheckAuthRoutePredicateFactory(Class configClass) {
        super(configClass);
    }

    @Override
    public Predicate<ServerWebExchange> apply(Object config) {
        return exchange -> {
            System.out.println("进入自定义的断言工厂" + ((Config) config).getName());
            if ("yinjihuan".equals(((Config) config).getName())) {
                return true;
            }
            return false;
        };
    }

    public static class Config {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
