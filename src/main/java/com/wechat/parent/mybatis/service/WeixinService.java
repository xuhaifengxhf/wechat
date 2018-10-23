package com.wechat.parent.mybatis.service;

/**
 * Created by lsq.
 */
public interface WeixinService {
    /**
     * <pre>
     * 验证消息的确来自微信服务器
     * 详情请见: http://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421135319&token=&lang=zh_CN
     * </pre>
     */
    boolean checkSignature(String timestamp, String nonce, String signature);

    /**
     * 处理事件
     *
     * @param requestBody
     * @return
     */
    String receiveMessage(String requestBody) throws Exception;
}
