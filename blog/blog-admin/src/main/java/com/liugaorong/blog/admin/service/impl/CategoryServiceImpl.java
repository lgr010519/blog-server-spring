package com.liugaorong.blog.admin.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liugaorong.blog.admin.mapper.CategoryMapper;
import com.liugaorong.blog.admin.service.CategoryService;
import com.liugaorong.blog.admin.vo.category.CategoryVo;
import com.liugaorong.blog.model.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author admin
 * @description 针对表【categories】的数据库操作Service实现
 * @createDate 2024-11-18 16:03:32
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category>
  implements CategoryService {
  
  @Autowired
  private CategoryMapper mapper;
  
  @Override
  public Page<CategoryVo> getList(Page<CategoryVo> page, String name) {
    
    Page<CategoryVo> categoryVoPage = mapper.selectCategoryPage(page, name);
    
    for (CategoryVo categoryVo :
      categoryVoPage.getRecords()) {
      Long articleNum = mapper.selectArticleCount(categoryVo.getId());
      categoryVo.setArticleNum(articleNum);
    }
    
    return categoryVoPage;
  }
}




