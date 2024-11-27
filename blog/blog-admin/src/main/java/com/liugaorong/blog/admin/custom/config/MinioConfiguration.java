package com.liugaorong.blog.admin.custom.config;

import com.liugaorong.blog.common.minio.MinioProperties;
import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(MinioProperties.class)
@ConditionalOnProperty(name = "minio.endpoint")
public class MinioConfiguration {
  
  @Autowired
  private MinioProperties properties;
  
  @Bean
  public MinioClient getClient() {
    return MinioClient.builder().endpoint(properties.getEndpoint())
      .credentials(properties.getAccessKey(), properties.getSecretKey())
      .build();
  }
}
