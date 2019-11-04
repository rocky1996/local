package com.acat.manage;

import com.acat.enums.ResponseCode;
import com.acat.response.SendResponse;
import feign.hystrix.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by IntelliJ IDEA.
 * User: wujinfan
 * Date: 2019-11-04
 */
@FeignClient(name = "${feign.user.server-name}",
    url = "${feign.user.url}",fallbackFactory = SystemFeignManager.DefaultFeign.class)
public interface SystemFeignManager {

    @GetMapping("/get/v1/getUser")
    public SendResponse getUser(@RequestParam("remote_user_class") String remote_user_class);

    /**
     * 容错的处理类
     */
    @Component
    class DefaultFeign implements FallbackFactory<SystemFeignManager>{

        @Override
        public SystemFeignManager create(Throwable throwable) {
            return new SystemFeignManager(){

                @Override
                public SendResponse getUser(String remote_user_class){
                    return SendResponse.failure(ResponseCode.ERROR_500.getCode(),ResponseCode.ERROR_500.getMsg());
                }
            };
        }
    }
}
