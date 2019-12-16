package com.dabai.springcloud.core.bean.config;

import com.dabai.springcloud.core.bean.interceptor.FeignBasicAuthRequestInterceptor;
import feign.Logger;
import feign.Request;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhuhaolin
 * @version 1.8.0
 * @description TODO
 * @date 2019-12-12 22:38
 **/
@Configuration
public class FeignConfiguration {
    @Bean
    public Logger.Level feignLoggerLever() {
        return Logger.Level.FULL;
    }

    @Bean
    public FeignBasicAuthRequestInterceptor feignBasicAuthRequestInterceptor() {
        return new FeignBasicAuthRequestInterceptor();
    }

    @Bean
    public Request.Options options() {
        return new Request.Options(60000, 60000);
    }
}
