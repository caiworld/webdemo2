package com.caihao.shirodemo1.service.impl;

import com.caihao.shirodemo1.entity.User;
import com.caihao.shirodemo1.mapper.UserMapper;
import com.caihao.shirodemo1.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UserService的实现类
 *
 * @Author 蔡浩
 * @Date 2019/4/2 14:53
 */
@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserMapper userMapper;

  @Override
  public User getUserByUsername(String username) {
    return userMapper.selectUserByUsername(username);
  }
}
