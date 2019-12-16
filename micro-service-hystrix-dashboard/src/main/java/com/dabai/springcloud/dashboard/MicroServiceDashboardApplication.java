package com.dabai.springcloud.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author zhuhaolin
 * @version 1.8.0
 * @description TODO
 * @date 2019-12-14 22:29
 **/
@EnableHystrixDashboard
@EnableEurekaClient
@SpringBootApplication
public class MicroServiceDashboardApplication {
    public static void main(String[] args) {
        SpringApplication.run(MicroServiceDashboardApplication.class, args);
    }
}
