//package com.wechat.parent.util;
//
//import org.springframework.data.redis.core.StringRedisTemplate;
//
//import java.util.UUID;
//import java.util.concurrent.TimeUnit;
//
///**
// * Created By Vincent on 2017/11/11
// */
//public class RedisManager {
//
//    private static StringRedisTemplate redisTemplate;
//
//    public static final Integer USER_CACHE_TIME = 60 * 60 * 24;
//
//    public static final Integer PHONE_NUM_CACHE_TIME = 60;
//
//
//
//    private static StringRedisTemplate getRedisTemplate() {
//        if (null == redisTemplate) {
//            redisTemplate = (StringRedisTemplate) SpringUtil.getBean("stringRedisTemplate");
//        }
//        return redisTemplate;
//    }
//
//    public static void set(String key, String value) {
//        getRedisTemplate().opsForValue().set(key, value, PHONE_NUM_CACHE_TIME, TimeUnit.SECONDS);
//    }
//
//    public static void set(String key, String value, long cacheTime) {
//        getRedisTemplate().opsForValue().set(key, value, cacheTime, TimeUnit.SECONDS);
//    }
//
//    public static String get(String key, String deft) {
//        String value = getRedisTemplate().opsForValue().get(key);
//        if (VStringUtil.isBlank(value)) {
//            return deft;
//        }
//        return value;
//    }
//    public static String get(String key) {
//        String value = getRedisTemplate().opsForValue().get(key);
//        return value;
//    }
//
//    public static void delete(String key) {
//        getRedisTemplate().delete(key);
//    }
//
//}
