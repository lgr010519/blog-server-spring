package com.liugaorong.blog.admin.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.liugaorong.blog.admin.vo.tags.TagsVo;
import com.liugaorong.blog.model.entity.Tags;

/**
 * @author admin
 * @description 针对表【tag】的数据库操作Service
 * @createDate 2024-11-20 11:19:15
 */
public interface TagService extends IService<Tags> {
  
  Page<TagsVo> getList(Page<TagsVo> page, String name, Integer status);
}
