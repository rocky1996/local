package com.acat.service.sendApple.impl;

import com.acat.common.CacheConst;
import com.acat.entity.ChildQueueEntity;
import com.acat.response.SendResponse;
import com.acat.service.cache.RedisService;
import com.acat.service.sendApple.SendAppleService;
import com.alibaba.fastjson.JSON;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

/**
 * Created by IntelliJ IDEA.
 * User: wujinfan
 * Date: 2019-11-19
 */
@Service("sendAppleService")
public class SendAppleServiceImpl implements SendAppleService {

    private Header[] headers = new BasicHeader[]{
            new BasicHeader("Content-Type", "application/json"),
            new BasicHeader("areaCode", "010"),
            new BasicHeader("ics-token", "446a654cf768818ef76645fd8a09eacd")
    };


    private Logger logger = LoggerFactory.getLogger(SendAppleServiceImpl.class);

    @Autowired
    private RedisService redisService;

    @Override
    public SendResponse openSendApple(String queueId, String timeDuanId) {
        String key = MessageFormat.format(CacheConst.childPlayState,queueId,timeDuanId);
        ChildQueueEntity queueEntity = getChildQueueEntity(key);
        return null;
    }

    public ChildQueueEntity getChildQueueEntity(String key){
        Object object = redisService.get(key);
        if(object == null){
            logger.info("[队列信息为空]start");
            return null;
        }
        return JSON.parseObject(String.valueOf(object),ChildQueueEntity.class);
    }
}
