package com.liugaorong.blog.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liugaorong.blog.admin.vo.about.AboutImgVo;
import com.liugaorong.blog.admin.vo.about.TagCloudVo;
import com.liugaorong.blog.model.entity.About;

import java.util.List;

/**
 * @author admin
 * @description 针对表【about】的数据库操作Mapper
 * @createDate 2024-11-25 11:49:18
 * @Entity com.liugaorong.blog.model.entity.About
 */
public interface AboutMapper extends BaseMapper<About> {
  
  List<About> selectAll();
  
  List<TagCloudVo> selectTagCloudList(Long id);
  
  List<AboutImgVo> selectAboutImgList(Long id);
  
  void updateAboutById(Long id, String description, String updateTime);
  
  void deleteAboutImg(Long id);
  
  void deleteTagCloud(Long id);
  
  void insertAboutImg(Long id, String imgUrl);
  
  void insertTagCloud(Long id, String name);
}




