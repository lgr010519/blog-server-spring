package com.liugaorong.blog.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liugaorong.blog.admin.mapper.CategoryMapper;
import com.liugaorong.blog.admin.service.CategoryService;
import com.liugaorong.blog.model.entity.Category;
import org.springframework.stereotype.Service;

/**
 * @author admin
 * @description 针对表【categories】的数据库操作Service实现
 * @createDate 2024-11-18 16:03:32
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category>
  implements CategoryService {
  
}




