package com.liugaorong.blog.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liugaorong.blog.admin.vo.tags.TagsVo;
import com.liugaorong.blog.model.entity.Tags;

/**
 * @author admin
 * @description 针对表【tag】的数据库操作Mapper
 * @createDate 2024-11-20 11:19:15
 * @Entity com.liugaorong.blog.admin.Tag
 */
public interface TagMapper extends BaseMapper<Tags> {
  
  Long selectArticleCount(Long tagId);
  
  Page<TagsVo> selectTagsPage(Page<TagsVo> page, String name, Integer status);
}




