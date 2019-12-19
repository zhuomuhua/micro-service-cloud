package com.dabai.springcloud.consumer.feign.fallback;

import com.dabai.springcloud.consumer.feign.ProviderClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author zhuhaolin
 * @version 1.8.0
 * @description TODO
 * @date 2019-12-20 0:41
 **/
@Slf4j
@Service
public class ProviderClientFallback implements ProviderClient {
    @Override
    public String update(String id, Integer age) {
        log.error("调用{}异常:{}", "update", id);
        return null;
    }
}
