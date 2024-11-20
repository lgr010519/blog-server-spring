package com.liugaorong.blog.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@MapperScan("com.liugaorong.blog.admin.mapper")
public class BlogAdminApplication {
  public static void main(String[] args) {
    SpringApplication.run(BlogAdminApplication.class, args);
  }
}
