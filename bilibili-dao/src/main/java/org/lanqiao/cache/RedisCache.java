package org.lanqiao.cache;

import org.apache.ibatis.cache.Cache;
import org.lanqiao.util.ApplicationContextUtil;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


public class RedisCache implements Cache {

     private String id;

    public RedisCache(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void putObject(Object key, Object value) {
        //获取redisTemplate对象
        RedisTemplate redisTemplate = (RedisTemplate) ApplicationContextUtil.getBean("redisTemplate");
        //存储缓存数据
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //设置HashKey序列化
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        //hash模型
        redisTemplate.opsForHash().put(id,key.toString(),value);
    }


    @Override
    public Object getObject(Object key) {
        //获取redisTemplate对象
        RedisTemplate redisTemplate = (RedisTemplate) ApplicationContextUtil.getBean("redisTemplate");
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //设置HashKey序列化
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        return redisTemplate.opsForHash().get(id.toString(),key.toString());
    }


    @Override
    public Boolean removeObject(Object key) {
        return null;
    }

    @Override
    public void clear() {
        //获取redisTemplate对象
        RedisTemplate redisTemplate = (RedisTemplate) ApplicationContextUtil.getBean("redisTemplate");
        redisTemplate.delete(id);
    }


    @Override
    public int getSize() {
//      获取redisTemplate对象
        RedisTemplate redisTemplate = (RedisTemplate) ApplicationContextUtil.getBean("redisTemplate");
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        return redisTemplate.opsForHash().size(id.toString()).intValue();
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return new ReentrantReadWriteLock();
    }
}
