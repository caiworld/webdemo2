package com.caihao.shirodemo1.controller;

import com.caihao.shirodemo1.entity.User;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * 登录
 *
 * @Author 蔡浩
 * @Date 2019/4/2 14:24
 */
@RestController
@Slf4j
public class LoginController {
  /**
   * 登录
   *
   * @param userName 用户名
   * @param password 密码
   * @return java.lang.String
   * @author 蔡浩
   * @date 2019/4/2 20:08
   * @since 1.0.0
   */
  @GetMapping("/login")
  public String login(String userName, String password) {
    // 使用shiro编写认证处理
    // 1.获取subject主体
    Subject subject = SecurityUtils.getSubject();
    // 2.封装用户数据
    UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
    try {
      // 执行登录
      subject.login(token);
    } catch (UnknownAccountException e) {
      return "账号错误";
    } catch (IncorrectCredentialsException e) {
      return "密码错误";
    }
    return "登录成功";
  }

  /**
   * 不需要登录即可访问
   *
   * @return java.lang.String
   * @author 蔡浩
   * @date 2019/4/2 20:08
   * @since 1.0.0
   */
  @GetMapping("/test")
  public String test() {
    System.out.println("test");
    return "test success";
  }

  @RequiresRoles({"2"})
  @GetMapping("/check_role")
  public String checkRole() {
    User user = (User) SecurityUtils.getSubject().getPrincipal();
    return "有要求的角色：" + user.getRole();
  }

  @RequiresPermissions({"select"})
  @GetMapping("/check_permission")
  public String checkPermission() {
    User user = (User) SecurityUtils.getSubject().getPrincipal();
    return "有要求的权限" + user.getPermission();
  }

  /**
   * 退出登录
   *
   * @return java.lang.String
   * @author 蔡浩
   * @date 2019/4/2 20:08
   * @since 1.0.0
   */
  @GetMapping("/logout")
  public String logout() {
    System.out.println("logout");
    SecurityUtils.getSubject().logout();
    return "logout";
  }
}
