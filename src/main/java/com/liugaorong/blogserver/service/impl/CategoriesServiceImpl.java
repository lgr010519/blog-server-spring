package com.liugaorong.blogserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liugaorong.blogserver.mapper.CategoriesMapper;
import com.liugaorong.blogserver.pojo.Categories;
import com.liugaorong.blogserver.service.CategoriesService;
import com.liugaorong.blogserver.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.Date;

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
        boolean b;
        try {
            b = super.save(categories);
        } catch (DuplicateKeyException e) {
            return Result.error("该分类已存在");
        }
        return Result.success(b);
    }

    @Override
    public Result get(int pageNum, int pageSize, String name) {
        Page<Categories> page = new Page<>(pageNum, pageSize);
        QueryWrapper<Categories> queryWrapper = new QueryWrapper<>();
        if (name != null) {
            queryWrapper.like("name", name);
        }
        Page<Categories> categoriesPage = super.page(page, queryWrapper);
        return Result.success(categoriesPage);
    }

    @Override
    public Result update(Categories categories) {
        UpdateWrapper<Categories> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", categories.getId())
                .set("name", categories.getName())
                .set("update_time", String.valueOf(new Date().getTime()));
        boolean b = super.update(null, updateWrapper);
        return Result.success(b);
    }

    @Override
    public Result remove(int id) {
        boolean b = super.removeById(id);
        return Result.success(b);
    }
}




