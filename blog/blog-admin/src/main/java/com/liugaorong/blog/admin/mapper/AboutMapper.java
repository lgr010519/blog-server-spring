package com.liugaorong.blog.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liugaorong.blog.admin.About;
import com.liugaorong.blog.admin.vo.login.AboutImgVo;
import com.liugaorong.blog.admin.vo.login.TagCloudVo;

import java.util.List;

/**
 * @author admin
 * @description 针对表【about】的数据库操作Mapper
 * @createDate 2024-11-25 11:49:18
 * @Entity com.liugaorong.blog.admin.About
 */
public interface AboutMapper extends BaseMapper<About> {
  
  List<About> selectAll();
  
  List<TagCloudVo> selectTagCloudList(Long id);
  
  List<AboutImgVo> selectAboutImgList(Long id);
}




