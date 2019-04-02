package com.caihao.shirodemo1.service;

import com.caihao.shirodemo1.entity.User;

/**
 * UserService
 *
 * @Author 蔡浩
 * @Date 2019/4/2 14:40
 */
public interface UserService {
  /**
   * 根据用户名获取用户信息
   *
   * @param username 用户名
   * @return com.caihao.shirodemo1.entity.User
   * @author 蔡浩
   * @date 2019/4/2 14:51
   * @since 1.0.0
   */
  User getUserByUsername(String username);
}
