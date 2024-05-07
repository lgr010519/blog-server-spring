package com.liugaorong.blogserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liugaorong.blogserver.mapper.TagsMapper;
import com.liugaorong.blogserver.pojo.Tags;
import com.liugaorong.blogserver.service.TagsService;
import com.liugaorong.blogserver.vo.Result;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author admin
 * @description 针对表【blog_tags】的数据库操作Service实现
 * @createDate 2024-05-07 09:53:09
 */
@Service
public class TagsServiceImpl extends ServiceImpl<TagsMapper, Tags>
        implements TagsService {

    @Override
    public Result add(Tags tags) {
        boolean b;
        try {
            b = super.save(tags);
        } catch (DuplicateKeyException e) {
            return Result.error("该标签已存在");
        }
        return Result.success(b);
    }

    @Override
    public Result get(int pageNum, int pageSize, String name) {
        Page<Tags> page = new Page<>(pageNum, pageSize);
        QueryWrapper<Tags> queryWrapper = new QueryWrapper<>();
        if (name != null) {
            queryWrapper.like("name", name);
        }
        Page<Tags> tagsPage = super.page(page, queryWrapper);
        return Result.success(tagsPage);
    }

    @Override
    public Result update(Tags tags) {
        UpdateWrapper<Tags> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", tags.getId())
                .set("name", tags.getName())
                .set("update_time", String.valueOf(new Date().getTime()));
        boolean b = super.update(null, updateWrapper);
        return Result.success(b);
    }

    @Override
    public Result updateStatus(Tags tags) {
        UpdateWrapper<Tags> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", tags.getId())
                .set("status", tags.getStatus());
        boolean b = super.update(null, updateWrapper);
        return Result.success(b);
    }

    @Override
    public Result remove(int id) {
        boolean b = super.removeById(id);
        return Result.success(b);
    }
}




