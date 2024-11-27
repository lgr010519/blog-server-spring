package com.liugaorong.blog.admin.service.impl;

import com.liugaorong.blog.admin.service.FileService;
import com.liugaorong.blog.common.minio.MinioProperties;
import io.minio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {
  
  @Autowired
  private MinioClient minioClient;
  
  @Autowired
  private MinioProperties properties;
  
  @Override
  public String upload(MultipartFile file) {
    
    try {
      boolean bucketExists = minioClient.bucketExists(BucketExistsArgs.builder().bucket(properties.getBucketName()).build());
      if (!bucketExists) {
        minioClient.makeBucket(MakeBucketArgs.builder().bucket(properties.getBucketName()).build());
        minioClient.setBucketPolicy(SetBucketPolicyArgs.builder().bucket(properties.getBucketName()).config(createBucketPolicyConfig(properties.getBucketName())).build());
      }
      
      String filename = new SimpleDateFormat("yyyyMMdd").format(new Date()) + "/" + UUID.randomUUID() + "-" + file.getOriginalFilename();
      minioClient.putObject(PutObjectArgs.builder().contentType(file.getContentType()).bucket(properties.getBucketName()).object(filename).stream(file.getInputStream(), file.getSize(), -1).build());
      
      return String.join("/", properties.getEndpoint(), properties.getBucketName(), filename);
      
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
  
  private String createBucketPolicyConfig(String bucketName) {
    
    return """
      {
        "Statement" : [ {
          "Action" : "s3:GetObject",
          "Effect" : "Allow",
          "Principal" : "*",
          "Resource" : "arn:aws:s3:::%s/*"
        } ],
        "Version" : "2012-10-17"
      }
      """.formatted(bucketName);
  }
}
