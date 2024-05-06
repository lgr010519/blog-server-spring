package com.liugaorong.blogserver.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.liugaorong.blogserver.pojo.Categories;
import com.liugaorong.blogserver.service.CategoriesService;
import com.liugaorong.blogserver.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("categories")
@CrossOrigin
public class CategoriesController {

    @Autowired
    private CategoriesService categoriesService;

    @PostMapping
    public Result add(@RequestBody Categories categories) {
        return categoriesService.add(categories);
    }

    @GetMapping
    public Result get(@RequestParam PageDTO dto) {
        return categoriesService.get(dto);
    }
}
