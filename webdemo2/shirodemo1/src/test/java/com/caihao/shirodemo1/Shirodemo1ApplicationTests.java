package com.caihao.shirodemo1;

import com.caihao.shirodemo1.entity.User;
import com.caihao.shirodemo1.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Shirodemo1ApplicationTests {
  @Autowired
  UserMapper userMapper;

  @Test
  public void contextLoads() {
    User user = userMapper.selectByPrimaryKey(1);
    System.out.println(user);
  }

}
