package com.dabai.springcloud.consumer.controller;

import com.dabai.springcloud.consumer.feign.DeptConsumerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author zhuhaolin
 * @version 1.8.0
 * @description TODO
 * @date 2019-12-08 14:39
 **/
@Slf4j
@RestController
@RequestMapping("/consumer")
public class DeptConsumerController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DeptConsumerService deptConsumerService;

    @GetMapping("/dept/{id}")
    public String get(@PathVariable String id) {
        log.info("【部门消费者】id = {}", id);
        String obj = restTemplate.getForObject("http://micro-service-provider/provider/dept/" + id, String.class);
        return obj;
    }

    @GetMapping("/feign/dept/{id}")
    public String getDept(@PathVariable String id) {
        String deptVO = deptConsumerService.get(id);
        return deptVO;
    }
}
