package com.liugaorong.blog.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liugaorong.blog.admin.vo.category.CategoryVo;
import com.liugaorong.blog.model.entity.Category;

/**
 * @author admin
 * @description 针对表【categories】的数据库操作Mapper
 * @createDate 2024-11-18 16:03:32
 * @Entity com.liugaorong.blog.model.entity.Categories
 */
public interface CategoryMapper extends BaseMapper<Category> {
  
  Long selectArticleCount(Long categoryId);
  
  Page<CategoryVo> selectCategoryPage(Page<CategoryVo> page, String name);
}




