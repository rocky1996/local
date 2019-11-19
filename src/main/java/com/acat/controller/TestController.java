package com.acat.controller;

import com.acat.response.SendResponse;
import com.acat.service.test.TestService;
import com.acat.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by IntelliJ IDEA.
 * User: wujinfan
 * Date: 2019-11-04
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @PostMapping("/v1/getKehu")
    public SendResponse getKehu(@RequestBody UserVo userVo){
        System.out.println(userVo);
        return testService.testUser(userVo);
    }
}
