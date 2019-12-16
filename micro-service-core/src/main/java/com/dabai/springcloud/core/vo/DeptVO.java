package com.dabai.springcloud.core.vo;

import lombok.Builder;
import lombok.Data;

/**
 * @author zhuhaolin
 * @version 1.8.0
 * @description TODO
 * @date 2019-12-12 22:44
 **/
@Data
@Builder
public class DeptVO {
    private String id;
    private String name;
}
