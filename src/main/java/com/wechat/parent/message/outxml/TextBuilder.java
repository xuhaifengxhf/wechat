package com.wechat.parent.message.outxml;


import com.wechat.parent.message.WxMpXmlOutTextMessage;

/**
 * 文本消息builder
 *
 * @author chanjarster
 */
public final class TextBuilder extends BaseBuilder<TextBuilder, WxMpXmlOutTextMessage> {
  private String content;

  public TextBuilder content(String content) {
    this.content = content;
    return this;
  }

  @Override
  public WxMpXmlOutTextMessage build() {
    WxMpXmlOutTextMessage m = new WxMpXmlOutTextMessage();
    setCommon(m);
    m.setContent(this.content);
    return m;
  }
}
