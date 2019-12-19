package com.dabai.springcloud.consumer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author zhuhaolin
 * @version 1.8.0
 * @description TODO
 * @date 2019-12-08 14:34
 **/
@MapperScan("com.dabai.springcloud.consumer.mapper")
@EnableHystrix
@EnableFeignClients
@EnableEurekaClient
@ComponentScan(basePackages = {"com.dabai.springcloud.consumer", "com.dabai.springcloud.core"})
@SpringBootApplication
public class MicroServiceConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(MicroServiceConsumerApplication.class, args);
    }
}
