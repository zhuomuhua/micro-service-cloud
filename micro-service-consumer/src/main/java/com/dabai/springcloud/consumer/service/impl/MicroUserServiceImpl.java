package com.dabai.springcloud.consumer.service.impl;

import com.dabai.springcloud.consumer.feign.ProviderClient;
import com.dabai.springcloud.consumer.mapper.MicroUserMapper;
import com.dabai.springcloud.consumer.service.MicroUserService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zhuhaolin
 * @version 1.8.0
 * @description TODO
 * @date 2019-12-20 0:31
 **/
@Slf4j
@Service
public class MicroUserServiceImpl implements MicroUserService {
    @Autowired
    private MicroUserMapper microUserMapper;

    @Autowired
    private ProviderClient providerClient;

    @Transactional(rollbackFor = Exception.class)
    @GlobalTransactional
    @Override
    public String update(String id, String name, Integer age) {
        log.info("【consumer服务】更新user, id = {}, name = {}", id, name);
        microUserMapper.updateMicroUser(id, name);
        String result = providerClient.update(id, age);
        if (StringUtils.isEmpty(result)) {
            throw new RuntimeException("更新provider失败, 事务回滚吧");
        }
        return "true";
    }
}
