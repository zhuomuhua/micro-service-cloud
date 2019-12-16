package com.dabai.springcloud.provider;

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
@ComponentScan(basePackages = {"com.dabai.springcloud.provider", "com.dabai.springcloud.core"})
public class MicroServiceProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(MicroServiceProviderApplication.class, args);
    }
}
