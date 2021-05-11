package pers.guzx.gatewayservice.predicates;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.util.List;
import java.util.function.Predicate;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/28 18:21
 * @describe 自定义断言工厂
 */
@ConfigurationProperties(prefix = "spring.cloud.gateway")
@Component
public class CustomerRoutePredicateFactory extends AbstractRoutePredicateFactory<CustomerRoutePredicateFactory.Config> {

    private RouteDefinition[] routes;

    public RouteDefinition[] getRoutes() {
        return routes;
    }

    public void setRoutes(RouteDefinition[] routes) {
        this.routes = routes;
    }

    public CustomerRoutePredicateFactory() {
        super(Config.class);
    }

    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        return exchange -> {
            System.out.println("进入自定义的断言工厂" + config.getName());
            if (routes[5].getPredicates().get(0).getArgs().get("name").equals(config.getName())) {
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
