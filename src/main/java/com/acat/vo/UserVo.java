package com.acat.vo;

import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: wujinfan
 * Date: 2019-11-04
 */
@Data
public class UserVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String remoteUserName;

    private String remoteUserClass;
}
