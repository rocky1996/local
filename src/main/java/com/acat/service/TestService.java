package com.acat.service;

import com.acat.response.SendResponse;
import com.acat.vo.UserVo;

/**
 * Created by IntelliJ IDEA.
 * User: wujinfan
 * Date: 2019-11-04
 */
public interface TestService {
    SendResponse testUser(UserVo userVo);
}
