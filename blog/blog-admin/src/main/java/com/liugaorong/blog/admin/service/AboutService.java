package com.liugaorong.blog.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liugaorong.blog.admin.dto.about.AboutDto;
import com.liugaorong.blog.admin.vo.about.AboutVo;
import com.liugaorong.blog.model.entity.About;

import java.util.List;

/**
 * @author admin
 * @description 针对表【about】的数据库操作Service
 * @createDate 2024-11-25 11:49:18
 */
public interface AboutService extends IService<About> {
  
  List<AboutVo> getList();
  
  void saveOrUpdateAbout(AboutDto aboutDto);
}
