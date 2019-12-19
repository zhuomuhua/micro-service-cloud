package com.dabai.springcloud.provider.controller;

import com.alibaba.fastjson.JSONObject;
import com.dabai.springcloud.provider.model.Dept;
import com.dabai.springcloud.provider.service.MicroExtendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhuhaolin
 * @version 1.8.0
 * @description TODO
 * @date 2019-12-08 14:11
 **/
@RestController
@RequestMapping("/provider")
public class DeptProviderController {
    @Autowired
    private MicroExtendService microExtendService;
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

    @GetMapping("/extend/{id}/{age}")
    public String update(@PathVariable String id, @PathVariable Integer age) {
        return microExtendService.update(id, age);
    }
}
