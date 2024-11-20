package com.liugaorong.blog.admin.controller.category;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liugaorong.blog.admin.service.CategoryService;
import com.liugaorong.blog.common.result.Result;
import com.liugaorong.blog.model.entity.Category;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Tag(name = "分类管理")
@RestController
@RequestMapping("/admin/category")
public class CategoryController {
  
  @Autowired
  private CategoryService service;
  
  @Operation(summary = "分类列表")
  @GetMapping("getList")
  public Result<IPage<Category>> getList(@RequestParam long current, @RequestParam long size, String name) {
    Page<Category> page = new Page<>(current, size);
    LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<>();
    queryWrapper.like(name != null, Category::getName, name);
    Page<Category> result = service.page(page, queryWrapper);
    return Result.ok(result);
  }
  
  @Operation(summary = "添加或修改分类")
  @PostMapping("saveOrUpdate")
  public Result saveOrUpdate(@RequestBody Category category) {
    service.saveOrUpdate(category);
    return Result.ok();
  }
  
  @Operation(summary = "删除分类")
  @DeleteMapping("remove")
  public Result remove(@RequestParam Long id) {
    service.removeById(id);
    return Result.ok();
  }
}
