package com.dabai.springcloud.adminweb;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author zhuhaolin
 * @version 1.8.0
 * @description TODO
 * @date 2019-12-15 21:52
 **/
@EnableEurekaClient
@EnableAdminServer
@SpringBootApplication
public class MicroServiceAdminWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(MicroServiceAdminWebApplication.class, args);
    }
}
