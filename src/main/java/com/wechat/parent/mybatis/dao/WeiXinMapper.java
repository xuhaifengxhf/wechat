package com.wechat.parent.mybatis.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;


/**
 * Created by dengb.
 */
@Mapper
@Component
public interface WeiXinMapper {

    /**
     * 查询当前用户有没有记录
     *
     * @param unionid
     * @param type
     * @return
     */
    Integer getCountWxUser(@Param(value = "unionid")String unionid,
                           @Param(value = "type")String type);
}
