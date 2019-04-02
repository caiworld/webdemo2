package com.caihao.shirodemo1;

import org.apache.shiro.crypto.hash.Md5Hash;

import java.util.UUID;

/**
 * TODO
 *
 * @Author 蔡浩
 * @Date 2019/4/2 16:27
 */
public class MD5Util {
  public static void main(String[] args) {
    UUID uuid = UUID.randomUUID();
    String salt = uuid.toString().replace("-", "");
    System.out.println(salt);
    Md5Hash md5Hash = new Md5Hash("456", salt, 2);
    System.out.println(md5Hash.toString());
  }
}
