package com.caihao.shirodemo1.mapper;

import com.caihao.shirodemo1.entity.User;
import com.caihao.shirodemo1.mapper.generator.MyMapper;

public interface UserMapper extends MyMapper<User> {

  /**
   * 根据用户名获取用户信息
   *
   * @param username 用户名
   * @return com.caihao.shirodemo1.entity.User
   * @author 蔡浩
   * @date 2019/4/2 14:55
   * @since 1.0.0
   */
  User selectUserByUsername(String username);
}