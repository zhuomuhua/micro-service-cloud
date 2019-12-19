package com.dabai.springcloud.consumer.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * @author zhuhaolin
 * @version 1.8.0
 * @description TODO
 * @date 2019-12-19 23:38
 **/
@Mapper
public interface MicroUserMapper {

    /**
     * 修改用户名称
     *
     * @param id
     * @param name
     * @return
     */
    @Update("UPDATE micro_user SET name = #{name} WHERE id = #{id}")
    int updateMicroUser(@Param("id") String id, @Param("name") String name);
}
