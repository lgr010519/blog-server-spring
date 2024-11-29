package com.liugaorong.blog.admin.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.liugaorong.blog.admin.vo.category.CategoryVo;
import com.liugaorong.blog.model.entity.Category;

/**
 * @author admin
 * @description 针对表【categories】的数据库操作Service
 * @createDate 2024-11-18 16:03:32
 */
public interface CategoryService extends IService<Category> {
  
  Page<CategoryVo> getList(Page<Category> page, Page<CategoryVo> pageVo, String name);
}
