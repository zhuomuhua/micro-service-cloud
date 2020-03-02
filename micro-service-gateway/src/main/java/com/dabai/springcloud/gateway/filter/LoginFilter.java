package com.dabai.springcloud.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author zhuhaolin
 * @version 1.8.0
 * @description TODO
 * @date 2020-01-03 0:16
 **/
@Slf4j
@Component
public class LoginFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        exchange.getAttributes().put("requestStartTime", System.currentTimeMillis());
        return chain.filter(exchange).then(Mono.fromRunnable(new Runnable() {
            @Override
            public void run() {
                Long startTime = exchange.getAttribute("requestStartTime");
                Long endTime = System.currentTimeMillis();
                if (!ObjectUtils.isEmpty(startTime)) {
                    String path = exchange.getRequest().getURI().getRawPath();
                    log.info("【网关请求耗时】地址：{}, 耗时：{}", path, (endTime - startTime));
                }
            }
        }));
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
