package com.caihao.shirodemo1.shiro;

import com.caihao.shirodemo1.entity.User;
import com.caihao.shirodemo1.service.UserService;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * TODO
 *
 * @Author 蔡浩
 * @Date 2019/4/2 14:33
 */
public class UserRealm extends AuthorizingRealm {

  @Autowired
  private UserService userService;

  /**
   * 授权处理
   *
   * @param principalCollection 权限集合
   * @return org.apache.shiro.authz.AuthorizationInfo
   * @author 蔡浩
   * @date 2019/4/2 14:34
   * @since 1.0.0
   */
  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
    // 这个方法获取的是认证处理里面认证信息的第一个参数
    User user = (User) principalCollection.getPrimaryPrincipal();
    SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
    // 设置角色
    Set<String> roleSet = new HashSet<>();
    String[] roles = user.getRole().split(",");
    roleSet.addAll(Arrays.asList(roles));
    info.setRoles(roleSet);
    // 设置权限
    Set<String> permissionSet = new HashSet<>();
    String[] permissions = user.getPermission().split(",");
    permissionSet.addAll(Arrays.asList(permissions));
    info.setStringPermissions(permissionSet);
    return info;
  }

  /**
   * 认证处理
   *
   * @param authenticationToken 身份验证token
   * @return org.apache.shiro.authc.AuthenticationInfo
   * @author 蔡浩
   * @date 2019/4/2 14:34
   * @since 1.0.0
   */
  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
          throws AuthenticationException {
    // 编写shiro判断逻辑，判断账号和密码
    UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
    // 1.判断账号
    String username = token.getUsername();
    System.out.println(token.getCredentials());
    System.out.println(token.getPrincipal());
    User user = userService.getUserByUsername(username);
    if (Objects.isNull(user)) {
      // 账号错误，Shiro底层会抛出UnknownAccountException异常
      return null;
    }
    String salt = user.getSalt();
    // 2.判断密码
    SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), "");
    // 设置密盐
    info.setCredentialsSalt(ByteSource.Util.bytes(salt));
    return info;
  }
}
