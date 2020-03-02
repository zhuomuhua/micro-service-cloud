package com.dabai.springcloud.consumer.controller;

import com.dabai.springcloud.consumer.feign.DeptConsumerClient;
import com.dabai.springcloud.consumer.service.MicroUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.atomic.AtomicLong;

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
    private DeptConsumerClient deptConsumerClient;

    @Autowired
    private MicroUserService microUserService;

    @GetMapping("/dept/{id}")
    public String get(@PathVariable String id) {
        log.info("【部门消费者】id = {}", id);
        String obj = restTemplate.getForObject("http://micro-service-provider/provider/dept/" + id, String.class);
        return obj;
    }

    @GetMapping("/feign/dept/{id}")
    public String getDept(@PathVariable String id) {
        String deptVO = deptConsumerClient.get(id);
        return deptVO;
    }

    @PatchMapping("/user/{id}/{name}/{age}")
    public String update(@PathVariable String id, @PathVariable String name, @PathVariable Integer age) {
        return microUserService.update(id, name, age);
    }


    public static void main(String[] args) {
        AtomicLong atomicLong = new AtomicLong(0L);
        long l = atomicLong.get();
        System.out.println(l);
        long l1 = atomicLong.addAndGet(1);
        System.out.println(l1);
        boolean b = atomicLong.compareAndSet(l1, l1 + 1);
        System.out.println(b);
        long l2 = atomicLong.get();
        System.out.println(l2);
    }
}
