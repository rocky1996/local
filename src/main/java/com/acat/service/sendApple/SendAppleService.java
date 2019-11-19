package com.acat.service.sendApple;

import com.acat.response.SendResponse;

/**
 * Created by IntelliJ IDEA.
 * User: wujinfan
 * Date: 2019-11-19
 */
public interface SendAppleService {

    /**
     * 开启发苹果
     * @param queueId
     * @param tiamDuanId
     * @return
     */
    SendResponse openSendApple(String queueId,String tiamDuanId);
}
