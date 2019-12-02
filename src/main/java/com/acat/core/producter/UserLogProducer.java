package com.acat.core.producter;

import com.acat.core.bean.UserLog;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * User: wujinfan
 * Date: 2019-12-02
 */
@Component
@Slf4j
public class UserLogProducer {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void send(){
        UserLog userLog = new UserLog();
        userLog.setId(System.currentTimeMillis()).setMsg(UUID.randomUUID().toString()).setSendTime(LocalDateTime.now());
        log.info("[发送用户日志数据]userLog:{}",userLog);
        kafkaTemplate.send("wujinfan", JSON.toJSONString(userLog));
    }
}

