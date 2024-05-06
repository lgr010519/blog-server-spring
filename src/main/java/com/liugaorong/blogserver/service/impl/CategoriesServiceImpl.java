package com.liugaorong.blogserver.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liugaorong.blogserver.mapper.CategoriesMapper;
import com.liugaorong.blogserver.pojo.Categories;
import com.liugaorong.blogserver.service.CategoriesService;
import com.liugaorong.blogserver.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

/**
 * @author admin
 * @description 针对表【blog_categories】的数据库操作Service实现
 * @createDate 2024-04-29 10:08:15
 */
@Service
public class CategoriesServiceImpl extends ServiceImpl<CategoriesMapper, Categories>
        implements CategoriesService {

    @Autowired
    private CategoriesMapper categoriesMapper;

    @Override
    public Result add(Categories categories) {
        try {
            boolean res = super.save(categories);
            if (!res) {
                return Result.error("添加失败");
            }
        } catch (DuplicateKeyException e) {
            return Result.error("该分类已添加");
        }
        return Result.success(1);
    }

    @Override
    public Result get(PageDTO dto) {
        Page<Categories> page = new Page<>(1, 6);
        Page<Categories> categoriesPage = categoriesMapper.selectPage(page, null);
        return Result.success(categoriesPage);
    }
}




