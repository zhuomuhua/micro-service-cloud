package com.dabai.springcloud.turbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * @author zhuhaolin
 * @version 1.8.0
 * @description TODO
 * @date 2019-12-16 21:11
 **/
@EnableTurbine
@EnableEurekaClient
@SpringBootApplication
public class MicroServiceTurbineApplication {
    public static void main(String[] args) {
        SpringApplication.run(MicroServiceTurbineApplication.class, args);
    }
}
