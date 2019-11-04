package com.acat.service.impl;

import com.acat.dao.UserDao;
import com.acat.entity.UserEntity;
import com.acat.manage.SystemFeignManager;
import com.acat.response.SendResponse;
import com.acat.service.TestService;
import com.acat.vo.UserVo;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: wujinfan
 * Date: 2019-11-04
 */
@Service("testService")
public class TestServiceImpl implements TestService {

    @Autowired
    private SystemFeignManager systemFeignManager;

    @Autowired
    private UserDao userDao;

    @Override
    public SendResponse testUser(UserVo userVo) {

        List<UserEntity> list = userDao.getUserEntityByClass(userVo.getRemoteUserClass());
        System.out.println(list);

        SendResponse sendResponse = systemFeignManager.getUser(userVo.getRemoteUserClass());
        System.out.println(sendResponse);

        return SendResponse.ok(list);
    }
}
