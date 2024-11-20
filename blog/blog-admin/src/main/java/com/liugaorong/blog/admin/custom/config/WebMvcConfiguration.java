package com.liugaorong.blog.admin.custom.config;

import com.liugaorong.blog.admin.custom.converter.StringToBaseEnumConverterFactory;
import com.liugaorong.blog.admin.custom.interceptor.AuthenticationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
  
  @Autowired
  private StringToBaseEnumConverterFactory stringToBaseEnumConverterFactory;
  
  @Autowired
  private AuthenticationInterceptor authenticationInterceptor;
  
  @Override
  public void addFormatters(FormatterRegistry registry) {
    registry.addConverterFactory(this.stringToBaseEnumConverterFactory);
  }
  
  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**") // 对所有路径应用规则
      .allowedOrigins("*") // 允许任何域名
      .allowedMethods("GET", "POST", "PUT", "DELETE") // 允许的请求方法
      .allowedHeaders("*") // 允许的请求头
      .maxAge(3600); // 缓存预检请求的时间（单位：秒）
  }

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(this.authenticationInterceptor).addPathPatterns("/admin/**").excludePathPatterns("/admin/login/**");
//    }
}
