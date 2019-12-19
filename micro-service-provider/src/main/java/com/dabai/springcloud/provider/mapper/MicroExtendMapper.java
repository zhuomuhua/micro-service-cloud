package com.dabai.springcloud.provider.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * @author zhuhaolin
 * @version 1.8.0
 * @description TODO
 * @date 2019-12-20 0:26
 **/
@Mapper
public interface MicroExtendMapper {

    /**
     * 修改年龄
     *
     * @param id
     * @param age
     * @return
     */
    @Update("UPDATE micro_extend SET age = #{age} WHERE user_id = #{id}")
    int updateMicroExtend(@Param("id") String id, @Param("age") Integer age);
}
