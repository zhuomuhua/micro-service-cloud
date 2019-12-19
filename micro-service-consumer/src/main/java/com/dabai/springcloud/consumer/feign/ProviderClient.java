package com.dabai.springcloud.consumer.feign;

import com.dabai.springcloud.consumer.feign.fallback.ProviderClientFallback;
import com.dabai.springcloud.core.bean.config.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zhuhaolin
 * @version 1.8.0
 * @description TODO
 * @date 2019-12-20 0:40
 **/
@FeignClient(value = "micro-service-provider", fallback = ProviderClientFallback.class, configuration = FeignConfiguration.class)
public interface ProviderClient {
    @GetMapping("/provider/extend/{id}/{age}")
    String update(@PathVariable("id") String id, @PathVariable("age") Integer age);
}
