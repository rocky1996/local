package com.acat.service.cache;

/**
 * Created by IntelliJ IDEA.
 * User: wujinfan
 * Date: 2019-11-19
 */
public interface RedisService {

    void set(String key,Object object);

    Object get(String key);

}
