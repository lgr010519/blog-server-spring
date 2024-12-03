package com.liugaorong.blog.admin.controller.comment;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liugaorong.blog.admin.service.CommentService;
import com.liugaorong.blog.admin.vo.comment.CommentVo;
import com.liugaorong.blog.common.result.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "评论管理")
@RestController
@RequestMapping("/admin/comment")
public class CommentController {
  
  @Autowired
  private CommentService service;
  
  @Operation(summary = "评论列表")
  @GetMapping("getList")
  public Result<IPage<CommentVo>> getList(@RequestParam long current, @RequestParam long size, String articleTitle, Integer auditStatus) {
    
    Page<CommentVo> page = new Page<>(current, size);
    Page<CommentVo> result = service.getList(page, articleTitle, auditStatus);
    
    return Result.ok(result);
  }
}
