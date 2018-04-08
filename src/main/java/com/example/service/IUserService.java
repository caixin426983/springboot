package com.example.service;

import com.example.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IUserService {
    /**
     * 查询所有
     *
     * @return
     */
    List<User> selectAll();

    /**
     * 根据ID查询实体
     *
     * @param id
     * @return
     */
    User getEntityById(@Param("id") Long id);
}
