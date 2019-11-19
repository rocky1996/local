package com.acat.service.cache.impl;

import com.acat.service.cache.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * User: wujinfan
 * Date: 2019-11-19
 */
@Service("redisService")
public class RedisServiceImpl implements RedisService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void set(String key, Object object) {
        //此处不设置缓存,默认为系统崩溃那一刻
        redisTemplate.opsForValue().set(key,object);
    }

    @Override
    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }
}
