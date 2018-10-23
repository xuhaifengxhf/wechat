package com.wechat.parent.mybatis.service.impl;

import com.wechat.parent.alisdk.ANY_CALL;
import com.wechat.parent.message.MessageUtil;
import com.wechat.parent.message.TextMessage;
import com.wechat.parent.message.WxMpXmlOutMessage;
import com.wechat.parent.message.WxMpXmlOutNewsMessage;
import com.wechat.parent.mybatis.dao.WeiXinMapper;
import com.wechat.parent.mybatis.service.WeixinService;
import com.wechat.parent.util.*;
import com.wechat.parent.wxpay.WXPayConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

@Service
public class WeixinServiceImpl implements WeixinService {
    @Autowired
    private WeiXinMapper weiXinMapper;
    @Override
    public boolean checkSignature(String timestamp, String nonce, String signature) {
        try {
            System.out.println("start check");
            return SHA2.isSignature(signature, timestamp, nonce, WXConfig.token);
        } catch (Exception e) {
            System.out.println("Checking signature failed, and the reason is :" + e.getMessage());
            return false;
        }
    }

    @Override
    public String receiveMessage(String requestBody) throws Exception {
        // 明文传输的消息
        Map map = new HashMap();
        map = MessageUtil.parseXml(requestBody);
        if (null == map)
            return "";
        System.out.println("事件requestBody="+requestBody);
        System.out.println("有事件推送" + map.toString());
        System.out.println("订阅消息:" + (String) map.get("Event"));
        //普通消息
//        if (WxConsts.MASS_MSG_TEXT.equalsIgnoreCase(map.get("MsgType"))) {
//            return handleTextMsg(inMessage);
//        } else if (WxConsts.BUTTON_CLICK.equalsIgnoreCase(inMessage.getEvent())) {
//            return handleClickMsg(inMessage);
//        } else
        if (MessageUtil.EVENT_TYPE_SUBSCRIBE.equalsIgnoreCase((String) map.get("Event"))) {
            System.out.println("订阅消息!");
            return handleSubscribeMsg(map);
        }
//        else if (WxConsts.EVT_SCAN.equalsIgnoreCase(inMessage.getEvent())) {
//            return handleScanMsg(inMessage);
//        }

        return "";
    }

    private String handleSubscribeMsg(Map map) {
//        String eventKey = inMessage.getEventKey();
//        if (VStringUtil.isNotBlank(eventKey) && eventKey.contains(VConfig.MARKET_EXCLUSIVE_QR_CODE)) {
//            setUserQrCode(eventKey, inMessage.getFromUser());
//        }
        System.out.println("FromUserName="+map.get("FromUserName"));
        System.out.println("ToUserName="+map.get("ToUserName"));
        WxMpXmlOutNewsMessage.Item item = new WxMpXmlOutNewsMessage.Item();
        // 下面是死链接
        item.setTitle("欢迎您关注！");
        item.setDescription("有问题请及时联系");
        WxMpXmlOutNewsMessage message = WxMpXmlOutMessage
                .NEWS()
                .fromUser((String) map.get("ToUserName"))
                .toUser((String) map.get("FromUserName"))
                .addArticle(item)
                .build();
//        WXPayConstants.MESSAGE_TEMPLATE_MAP_PURCHASE_GROUP.put("first", WXPayConstants.ServiceOrderCreate);
//        WXPayConstants.MESSAGE_TEMPLATE_MAP_PURCHASE_GROUP.put("ordertape", "测试");
//        WXPayConstants.MESSAGE_TEMPLATE_MAP_PURCHASE_GROUP.put("ordeID", "123456");
//        //getCreated().getTime() + "_" + groupPurchase.getId());
//        WXPayConstants.MESSAGE_TEMPLATE_MAP_PURCHASE_GROUP.put("remark", "服务单推送失败,请重试");
//        String url = "http://www.mxjzq.com/mingxiao/user/info";
//        WechatUtil.sendMessage((String) map.get("FromUserName"), url, WXPayConstants.MESSAGE_TEMPLATE_PURCHASE_GROUP,
//                WXPayConstants.MESSAGE_TEMPLATE_MAP_PURCHASE_GROUP);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        if (VStringUtil.isBlank(inMessage.getEventKey()) || !inMessage.getEventKey().startsWith(VConfig.ORDER_OTA_QR_CODE_PREFIX_BY_SUBSCRIBE))
//            return message.toXml();
        //查看当前openid在数据库是否有记录
        //查询当前关注人员用户信息
        WxMpUser user = HttpClientUtil.getWxUserInfo((String) map.get("FromUserName"));
        System.out.println("用户信息"+user.toString());
        if (!StringUtils.isEmpty(user.getUnionId())){
            //先判断是否已经存在数据库中
            if (weiXinMapper.getCountWxUser(user.getUnionId(),"wechat") < 1) {
                ANY_CALL.crateWxUser(user.getOpenId(), user.getOpenId(), "", user.getHeadImgUrl(), "wechat", "");
            }
        }
        //存储在数据库 type = 记录为subscribe
        String ret = message.toXml();
        System.out.println(ret);
        return ret;
    }
}
