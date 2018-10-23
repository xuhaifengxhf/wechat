package com.wechat.parent.mybatis.service;

/**
 * Created by dengb.
 */
public interface MiniProgramService {

    /**
     * 处理事件
     *
     * @param code
     * @return
     */
    String getMiniUserInfo(String code) throws Exception;
}
