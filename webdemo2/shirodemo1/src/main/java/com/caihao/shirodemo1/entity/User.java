package com.caihao.shirodemo1.entity;

import javax.persistence.*;

@Table(name = "`user`")
public class User {
  /**
   * 主键id，自增长
   */
  @Id
  @Column(name = "`id`")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  /**
   * 用户名
   */
  @Column(name = "`user_name`")
  private String userName;

  /**
   * 密码
   */
  @Column(name = "`password`")
  private String password;

  /**
   * 密盐
   */
  @Column(name = "`salt`")
  private String salt;

  /**
   * 1.普通用户，2.admin
   */
  @Column(name = "`role`")
  private String role;

  /**
   * 权限
   */
  @Column(name = "`permission`")
  private String permission;

  /**
   * 获取主键id，自增长
   *
   * @return id - 主键id，自增长
   */
  public Integer getId() {
    return id;
  }

  /**
   * 设置主键id，自增长
   *
   * @param id 主键id，自增长
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * 获取用户名
   *
   * @return user_name - 用户名
   */
  public String getUserName() {
    return userName;
  }

  /**
   * 设置用户名
   *
   * @param userName 用户名
   */
  public void setUserName(String userName) {
    this.userName = userName;
  }

  /**
   * 获取密码
   *
   * @return password - 密码
   */
  public String getPassword() {
    return password;
  }

  /**
   * 设置密码
   *
   * @param password 密码
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * 获取密盐
   *
   * @return salt - 密盐
   */
  public String getSalt() {
    return salt;
  }

  /**
   * 设置密盐
   *
   * @param salt 密盐
   */
  public void setSalt(String salt) {
    this.salt = salt;
  }

  /**
   * 获取1.普通用户，2.admin
   *
   * @return role - 1.普通用户，2.admin
   */
  public String getRole() {
    return role;
  }

  /**
   * 设置1.普通用户，2.admin
   *
   * @param role 1.普通用户，2.admin
   */
  public void setRole(String role) {
    this.role = role;
  }

  public String getPermission() {
    return permission;
  }

  public void setPermission(String permission) {
    this.permission = permission;
  }
}