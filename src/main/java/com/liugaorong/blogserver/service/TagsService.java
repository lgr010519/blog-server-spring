package com.liugaorong.blogserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liugaorong.blogserver.pojo.Tags;
import com.liugaorong.blogserver.vo.Result;

/**
 * @author admin
 * @description 针对表【blog_tags】的数据库操作Service
 * @createDate 2024-05-07 09:53:09
 */
public interface TagsService extends IService<Tags> {

    Result add(Tags tags);

    Result get(int pageNum, int pageSize, String name);

    Result update(Tags tags);

    Result updateStatus(Tags tags);

    Result remove(int id);
}
