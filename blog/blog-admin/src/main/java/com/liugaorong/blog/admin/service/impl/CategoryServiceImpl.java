package com.liugaorong.blog.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liugaorong.blog.admin.mapper.CategoryMapper;
import com.liugaorong.blog.admin.service.CategoryService;
import com.liugaorong.blog.admin.vo.category.CategoryVo;
import com.liugaorong.blog.model.entity.Category;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
  public Page<CategoryVo> getList(Page<Category> page, Page<CategoryVo> pageVo, String name) {
    
    LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<>();
    queryWrapper.like(name != null, Category::getName, name);
    Page<Category> result = page(page, queryWrapper);
    
    List<CategoryVo> categoryVoList = new ArrayList<>();
    
    for (Category category :
      result.getRecords()) {
      CategoryVo categoryVo = new CategoryVo();
      BeanUtils.copyProperties(category, categoryVo);
      Long count = mapper.selectArticleCount(category.getId());
      categoryVo.setArticleNum(count);
      categoryVoList.add(categoryVo);
    }
    
    pageVo.setRecords(categoryVoList);
    
    return pageVo;
  }
}




