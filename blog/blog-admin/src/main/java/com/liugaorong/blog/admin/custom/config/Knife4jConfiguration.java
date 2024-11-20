package com.liugaorong.blog.admin.custom.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Knife4jConfiguration {
  
  @Bean
  public OpenAPI customOpenAPI() {
    
    return new OpenAPI().info(
      new Info()
        .title("后台管理系统API")
        .version("1.0")
        .description("后台管理系统API"));
  }
  
  @Bean
  public GroupedOpenApi systemAPI() {
    
    return GroupedOpenApi.builder().group("后台管理").
      pathsToMatch(
        "/admin/**"
      ).
      build();
  }
}