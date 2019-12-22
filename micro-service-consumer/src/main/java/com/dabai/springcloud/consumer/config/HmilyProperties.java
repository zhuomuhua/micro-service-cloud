package com.dabai.springcloud.consumer.config;

/**
 * @author zhuhaolin
 * @version 1.8.0
 * @description TODO
 * @date 2019-12-22 15:32
 **/
//@Data
//@Configuration
//@ConfigurationProperties(prefix = "org.dromara.hmily")
public class HmilyProperties {
    private String serializer;
    private Integer recoverDelayTime;
    private Integer retryMax;
    private Integer scheduledDelay;
    private Integer scheduledThreadMax;
    private String repositorySupport;
    private Boolean started;
}

