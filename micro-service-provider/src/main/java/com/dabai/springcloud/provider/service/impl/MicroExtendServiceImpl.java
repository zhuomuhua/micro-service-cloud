package com.dabai.springcloud.provider.service.impl;

import com.dabai.springcloud.provider.mapper.MicroExtendMapper;
import com.dabai.springcloud.provider.service.MicroExtendService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zhuhaolin
 * @version 1.8.0
 * @description TODO
 * @date 2019-12-19 23:43
 **/
@Slf4j
@Service
public class MicroExtendServiceImpl implements MicroExtendService {
    @Autowired
    private MicroExtendMapper extendMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public String update(String id, Integer age) {
        log.info("【provider服务】更新extend, id = {}, age = {}", id, age);
        if (age < 25) {
            throw new RuntimeException("年龄太小了");
        }
        extendMapper.updateMicroExtend(id, age);
        return "true";
    }
}
