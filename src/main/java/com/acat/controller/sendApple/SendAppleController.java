package com.acat.controller.sendApple;

import com.acat.enums.ResponseCode;
import com.acat.response.SendResponse;
import com.acat.service.sendApple.SendAppleService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * User: wujinfan
 * Date: 2019-11-19
 */
@RestController
@RequestMapping("/sendApple")
public class SendAppleController {

    private Logger logger = LoggerFactory.getLogger(SendAppleController.class);

    @Autowired
    private SendAppleService sendAppleService;

    @GetMapping(value = "/open")
    public SendResponse openSendApple(String queueId,String tiamDuanId){
        logger.info("[开启玩耍中发苹果]start,queueId:{},tiamDuanId:{}",queueId,tiamDuanId);

        if(StringUtils.isBlank(queueId)){
            return SendResponse.failure(ResponseCode.ERROR_1.getCode(), "参数不能为空");
        }

        if(StringUtils.isBlank(tiamDuanId)){
            return SendResponse.failure(ResponseCode.ERROR_1.getCode(), "参数不能为空");
        }

        SendResponse sendResponse = sendAppleService.openSendApple(queueId,tiamDuanId);
        if(sendResponse.getCode() == 0){
            //数据打点
        }

        return sendResponse;
    }

    @GetMapping(value = "/close")
    public void openSendApple(){

    }

}
