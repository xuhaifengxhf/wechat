package com.wechat.parent.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.wechat.parent.message.outxml.NewsBuilder;
import com.wechat.parent.message.outxml.TextBuilder;
import com.wechat.parent.message.xml.XStreamTransformer;
import me.chanjar.weixin.common.util.xml.XStreamCDataConverter;

import java.io.Serializable;

@XStreamAlias("xml")
public abstract class WxMpXmlOutMessage implements Serializable {
    private static final long serialVersionUID = -381382011286216263L;

    @XStreamAlias("ToUserName")
    @XStreamConverter(value = XStreamCDataConverter.class)
    protected String toUserName;

    @XStreamAlias("FromUserName")
    @XStreamConverter(value = XStreamCDataConverter.class)
    protected String fromUserName;

    @XStreamAlias("CreateTime")
    protected Long createTime;

    @XStreamAlias("MsgType")
    @XStreamConverter(value = XStreamCDataConverter.class)
    protected String msgType;

    /**
     * 获得文本消息builder
     */
    public static TextBuilder TEXT() {
        return new TextBuilder();
    }
    /**
     * 获得图文消息builder
     */
    public static NewsBuilder NEWS() {
        return new NewsBuilder();
    }


    public String getToUserName() {
        return this.toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getFromUserName() {
        return this.fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public Long getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getMsgType() {
        return this.msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    @SuppressWarnings("unchecked")
    public String toXml() {
        return XStreamTransformer.toXml((Class<WxMpXmlOutMessage>) this.getClass(), this);
    }

}
