package com.acat.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: wujinfan
 * Date: 2019-10-31
 */
@Data
@Entity
@Table(name = "remote_user")
public class UserEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "remote_user_id")
    private String remoteUserId;

    @Column(name = "remote_user_name")
    private String remoteUserName;

    @Column(name = "remote_user_class")
    private String remoteUserClass;
}
