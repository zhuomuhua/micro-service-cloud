package com.dabai.springcloud.consumer.feign.factory;

import com.dabai.springcloud.consumer.feign.DeptConsumerService;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author zhuhaolin
 * @version 1.8.0
 * @description TODO
 * @date 2019-12-14 22:10
 **/
@Slf4j
@Component
public class DeptConsumerServiceFallbackFactory implements FallbackFactory<DeptConsumerService> {
    @Override
    public DeptConsumerService create(Throwable throwable) {
        return new DeptConsumerService() {
            @Override
            public String get(String id) {
                log.error("调用{}异常:{}", "get", id);
                return null;
            }
        };
    }
}
