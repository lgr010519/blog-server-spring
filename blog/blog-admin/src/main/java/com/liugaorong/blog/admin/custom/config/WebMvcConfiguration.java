package com.liugaorong.blog.admin.custom.config;

import com.liugaorong.blog.admin.custom.converter.StringToBaseEnumConverterFactory;
import com.liugaorong.blog.admin.custom.interceptor.AuthenticationInterceptor;
import com.liugaorong.blog.admin.custom.interceptor.CorsInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
  
  @Autowired
  private StringToBaseEnumConverterFactory stringToBaseEnumConverterFactory;
  
  @Autowired
  private CorsInterceptor corsInterceptor;
  
  @Autowired
  private AuthenticationInterceptor authenticationInterceptor;
  
  @Override
  public void addFormatters(FormatterRegistry registry) {
    registry.addConverterFactory(stringToBaseEnumConverterFactory);
  }
  
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(corsInterceptor);
    registry.addInterceptor(authenticationInterceptor).addPathPatterns("/admin/**").excludePathPatterns("/admin/login/**");
  }
}
