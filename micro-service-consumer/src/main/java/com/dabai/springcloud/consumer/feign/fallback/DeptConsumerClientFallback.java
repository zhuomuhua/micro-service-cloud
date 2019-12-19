package com.dabai.springcloud.consumer.feign.fallback;

import com.dabai.springcloud.consumer.feign.DeptConsumerClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author zhuhaolin
 * @version 1.8.0
 * @description TODO
 * @date 2019-12-12 22:45
 **/
@Slf4j
@Service
public class DeptConsumerClientFallback implements DeptConsumerClient {
    @Override
    public String get(String id) {
        log.error("调用{}异常:{}", "get", id);
        return null;
    }
}
