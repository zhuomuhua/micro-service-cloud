package com.dabai.springcloud.provider.service.impl;

import com.dabai.springcloud.provider.mapper.MicroExtendMapper;
import com.dabai.springcloud.provider.service.MicroExtendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhuhaolin
 * @version 1.8.0
 * @description TODO
 * @date 2019-12-19 23:43
 **/
@Service
public class MicroExtendServiceImpl implements MicroExtendService {
    @Autowired
    private MicroExtendMapper extendMapper;

    @Override
    public String update(String id, String name) {
        extendMapper.updateMicroExtend(id, name);
        return "true";
    }
}
