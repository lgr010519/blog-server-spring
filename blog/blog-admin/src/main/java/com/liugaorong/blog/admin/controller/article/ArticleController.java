package com.liugaorong.blog.admin.controller.article;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liugaorong.blog.admin.dto.article.ArticleDto;
import com.liugaorong.blog.admin.dto.article.ArticleQueryDto;
import com.liugaorong.blog.admin.service.ArticleService;
import com.liugaorong.blog.admin.vo.article.ArticleVo;
import com.liugaorong.blog.common.result.Result;
import com.liugaorong.blog.model.entity.Article;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Tag(name = "文章管理")
@RestController
@RequestMapping("/admin/article")
public class ArticleController {
  
  @Autowired
  private ArticleService service;
  
  @Operation(summary = "获取文章列表")
  @GetMapping("getList")
  public Result<IPage<ArticleVo>> getList(@RequestParam long current, @RequestParam long size, ArticleQueryDto queryDto) {
    
    Page<ArticleVo> page = new Page<>(current, size);
    Page<ArticleVo> result = service.getList(page, queryDto);
    
    return Result.ok(result);
  }
  
  @Operation(summary = "添加或修改文章")
  @PostMapping("saveOrUpdate")
  public Result saveOrUpdate(@RequestBody ArticleDto articleDto) {
    
    service.saveOrUpdateArticle(articleDto);
    
    return Result.ok();
  }
  
  @Operation(summary = "修改文章启用状态和发布状态")
  @PostMapping("updateStatus")
  public Result updateStatus(@RequestBody Article article) {
    
    LambdaUpdateWrapper<Article> updateWrapper = new LambdaUpdateWrapper<>();
    
    updateWrapper.eq(Article::getId, article.getId())
      .set(article.getStatus() != null, Article::getStatus, article.getStatus())
      .set(article.getPublishStatus() != null, Article::getPublishStatus, article.getPublishStatus());
    
    service.update(updateWrapper);
    
    return Result.ok();
  }
  
  @Operation(summary = "删除文章")
  @DeleteMapping("remove")
  public Result saveOrUpdate(@RequestParam Long id) {
    
    service.removeById(id);
    
    return Result.ok();
  }
}
