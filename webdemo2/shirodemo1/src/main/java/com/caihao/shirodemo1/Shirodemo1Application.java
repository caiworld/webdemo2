package com.caihao.shirodemo1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.caihao.shirodemo1.mapper")
public class Shirodemo1Application {

  public static void main(String[] args) {
    SpringApplication.run(Shirodemo1Application.class, args);
  }

}
