package com.dabai.springcloud.provider.model;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

/**
 * @author zhuhaolin
 * @version 1.8.0
 * @description TODO
 * @date 2019-12-06 23:46
 **/
@Data
@Builder
public class Dept {
    private String id;
    private String name;
}
