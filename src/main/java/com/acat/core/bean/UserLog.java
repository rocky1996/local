package com.acat.core.bean;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * Created by IntelliJ IDEA.
 * User: wujinfan
 * Date: 2019-12-02
 */
@Data
@Accessors(chain = true)
public class UserLog {

    private Long id;

    private String msg;

    private LocalDateTime sendTime;
}
