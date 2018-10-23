//package com.wechat.parent.jedis;
//
//
//import org.springframework.util.StringUtils;
//
//public class JedisConnectionFactory extends org.springframework.data.redis.connection.jedis.JedisConnectionFactory {
//
//    /**
//     * 待解密的字符串前缀
//     */
//    private static final String ENC_STR = "ENC:";
//
//    @Override
//    public void setHostName(String hostName) {
//        if (StringUtils.startsWithIgnoreCase(hostName, ENC_STR)) {
////            String value = StringUtils.substringAfter(hostName, ENC_STR);
//////            value = SpringPropertyCoder.decode(value);
//            super.setHostName(hostName);
//        } else {
//            super.setHostName(hostName);
//        }
//    }
//
//    @Override
//    public void setPassword(String password) {
//        if (StringUtils.startsWithIgnoreCase(password, ENC_STR)) {
////            String value = VStringUtil.substringAfter(password, ENC_STR);
////            value = SpringPropertyCoder.decode(value);
//            super.setPassword(password);
//        } else {
//            super.setPassword(password);
//        }
//    }
//
//    @Override
//    public void setPort(int port) {
//        super.setPort(port);
//    }
//
//}
