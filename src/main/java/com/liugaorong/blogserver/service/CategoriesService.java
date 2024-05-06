package com.liugaorong.blogserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liugaorong.blogserver.pojo.Categories;
import com.liugaorong.blogserver.vo.Result;

/**
 * @author admin
 * @description 针对表【blog_categories】的数据库操作Service
 * @createDate 2024-04-29 10:08:15
 */
public interface CategoriesService extends IService<Categories> {

    Result add(Categories categories);

    Result get(int pageNum, int pageSize, String name);

    Result update(Categories categories);

    Result remove(int id);
}
