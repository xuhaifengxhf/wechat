//package com.wechat.parent.config;
//
//import com.alibaba.fastjson.PropertyNamingStrategy;
//import com.alibaba.fastjson.serializer.SerializeConfig;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.ImportResource;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import redis.clients.jedis.JedisPoolConfig;
//
///**
// * Created By Vincent on 2018/2/7
// */
//@Configuration
//@ImportResource(locations = {"classpath:context/applicationContext-cache.xml"})
//public class ApplicationConfig {
//    static {
//        SerializeConfig.getGlobalInstance().propertyNamingStrategy = PropertyNamingStrategy.SnakeCase;
//    }
//
//
//    @Bean
//    public JedisPoolConfig jedisPoolConfig() {
//        return new JedisPoolConfig();
//    }
//
//    @Bean
//    public JedisConnectionFactory jedisConnectionFactory(JedisPoolConfig jedisPoolConfig) {
//        return new JedisConnectionFactory(jedisPoolConfig);
//    }
//
//    @Bean
//    public StringRedisTemplate stringRedisTemplate(JedisConnectionFactory jedisConnectionFactory) {
//        return new StringRedisTemplate(jedisConnectionFactory);
//    }
//
//}
