package com.dabai.springcloud.consumer.feign;

import com.dabai.springcloud.consumer.feign.fallback.DeptConsumerClientFallback;
import com.dabai.springcloud.core.bean.config.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zhuhaolin
 * @version 1.8.0
 * @description TODO
 * @date 2019-12-12 22:41
 **/
@FeignClient(name = "micro-service-provider", fallback = DeptConsumerClientFallback.class, configuration = FeignConfiguration.class)
public interface DeptConsumerClient {
    /**
     * 获取部门信息
     *
     * @param id
     * @return
     */
    @GetMapping("/provider/dept/{id}")
    String get(@PathVariable String id);
}
