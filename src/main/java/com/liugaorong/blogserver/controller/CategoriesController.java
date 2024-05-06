package com.liugaorong.blogserver.controller;

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
    public Result get(@RequestParam int pageNum, int pageSize, String name) {
        return categoriesService.get(pageNum, pageSize, name);
    }

    @PutMapping
    public Result update(@RequestBody Categories categories) {
        return categoriesService.update(categories);
    }

    @DeleteMapping("/{id}")
    public Result remove(@PathVariable int id) {
        return categoriesService.remove(id);
    }
}
