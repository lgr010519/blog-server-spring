package com.liugaorong.blog.admin.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
  
  String upload(MultipartFile file);
}