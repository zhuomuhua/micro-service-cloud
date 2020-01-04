package com.dabai.springcloud.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author zhuhaolin
 * @version 1.8.0
 * @description TODO
 * @date 2020-01-03 0:16
 **/
@Component
public class LoginFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
