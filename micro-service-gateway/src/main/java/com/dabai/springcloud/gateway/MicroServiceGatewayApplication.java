package com.dabai.springcloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author zhuhaolin
 * @version 1.8.0
 * @description TODO
 * @date 2019-12-26 22:11
 **/
@EnableEurekaClient
@SpringBootApplication
public class MicroServiceGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(MicroServiceGatewayApplication.class, args);
    }
}
