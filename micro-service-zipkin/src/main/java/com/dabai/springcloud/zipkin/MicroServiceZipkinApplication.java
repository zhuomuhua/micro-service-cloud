package com.dabai.springcloud.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author zhuhaolin
 * @version 1.8.0
 * @description TODO
 * @date 2019-12-15 17:57
 **/
@EnableEurekaClient
@SpringBootApplication
public class MicroServiceZipkinApplication {
    public static void main(String[] args) {
        SpringApplication.run(MicroServiceZipkinApplication.class, args);
    }
}
