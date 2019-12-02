package com.acat.core.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * User: wujinfan
 * Date: 2019-12-02
 */
@Component
@Slf4j
public class UserLogConsumer {

    @KafkaListener(topics = {"wujinfan"})
    public void consumer(ConsumerRecord<?,?> consumerRecord){
        //判断是否为空
        Optional<?> kafkaMessage = Optional.ofNullable(consumerRecord.value());
        log.info(">>>>>>>>>> record =" + kafkaMessage);
        if(kafkaMessage.isPresent()){
            //得到Optional实例中的值
            Object message = kafkaMessage.get();
            log.info("------consumerRecord------="+consumerRecord);
            log.info("------message-------="+message);
        }
    }

}
