package com.example.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserMapper extends BaseMapper<User> {


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
