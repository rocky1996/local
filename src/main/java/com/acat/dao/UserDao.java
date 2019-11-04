package com.acat.dao;

import com.acat.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: wujinfan
 * Date: 2019-10-31
 */
public interface UserDao extends JpaRepository<UserEntity,Integer> {

    @Query(value = "select en from UserEntity en where en.remoteUserClass=?1")
    List<UserEntity> getUserEntityByClass(String remote_user_class);

}
