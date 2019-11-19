package com.acat.service.test;

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
