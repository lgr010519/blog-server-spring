package com.liugaorong.blog.admin.controller.tag;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liugaorong.blog.admin.service.TagService;
import com.liugaorong.blog.admin.vo.tags.TagsVo;
import com.liugaorong.blog.common.result.Result;
import com.liugaorong.blog.model.entity.Tags;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Tag(name = "标签管理")
@RestController
@RequestMapping("/admin/tag")
public class TagController {
  
  @Autowired
  private TagService service;
  
  @Operation(summary = "标签列表")
  @GetMapping("getList")
  public Result<IPage<TagsVo>> getList(@RequestParam long current, @RequestParam long size, String name, Integer status) {
    
    Page<TagsVo> page = new Page<>(current, size);
    Page<TagsVo> result = service.getList(page, name, status);
    
    return Result.ok(result);
  }
  
  @Operation(summary = "添加或修改标签")
  @PostMapping("saveOrUpdate")
  public Result saveOrUpdate(@RequestBody Tags tags) {
    service.saveOrUpdate(tags);
    return Result.ok();
  }
  
  @Operation(summary = "删除标签")
  @DeleteMapping("remove")
  public Result remove(@RequestParam Long id) {
    service.removeById(id);
    return Result.ok();
  }
}
