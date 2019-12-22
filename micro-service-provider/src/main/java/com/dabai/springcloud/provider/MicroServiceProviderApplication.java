package com.dabai.springcloud.provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author zhuhaolin
 * @version 1.8.0
 * @description TODO
 * @date 2019-12-08 14:13
 **/
@EnableEurekaClient
@SpringBootApplication
@MapperScan("com.dabai.springcloud.provider.mapper")
//@ComponentScan(basePackages = {"com.dabai.springcloud.provider", "com.dabai.springcloud.core", "org.dromara.hmily"})
@ComponentScan(basePackages = {"com.dabai.springcloud.provider", "com.dabai.springcloud.core"})
public class MicroServiceProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(MicroServiceProviderApplication.class, args);
    }
}
