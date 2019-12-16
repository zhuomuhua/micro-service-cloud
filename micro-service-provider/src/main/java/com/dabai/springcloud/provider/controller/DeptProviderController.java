package com.dabai.springcloud.provider.controller;

import com.alibaba.fastjson.JSONObject;
import com.dabai.springcloud.provider.model.Dept;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhuhaolin
 * @version 1.8.0
 * @description TODO
 * @date 2019-12-08 14:11
 **/
@RestController
@RequestMapping("/provider")
public class DeptProviderController {
    /**
     * 获取部门信息
     *
     * @param id
     * @return
     */
    @GetMapping("/dept/{id}")
    public String get(@PathVariable String id) {
        return JSONObject.toJSONString(Dept.builder().id(id).name("zhuhaolin").build());
    }
}
