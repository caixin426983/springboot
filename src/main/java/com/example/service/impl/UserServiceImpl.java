package com.example.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.mapper.IUserMapper;
import com.example.entity.User;
import com.example.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl extends ServiceImpl<IUserMapper, User> implements IUserService {

    @Autowired
    private IUserMapper userMapper;

    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }

    @Override
    public User getEntityById(Long id) {
        return userMapper.getEntityById(id);
    }

    @Override
    public User getEntityByName(String name) {
        User user = new User();
        return  userMapper.selectOne(user);
    }

}
