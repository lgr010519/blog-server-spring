package com.liugaorong.blog.admin.controller.comment;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liugaorong.blog.admin.service.CommentService;
import com.liugaorong.blog.admin.vo.comment.CommentVo;
import com.liugaorong.blog.common.result.Result;
import com.liugaorong.blog.model.entity.Comment;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
  
  @Operation(summary = "评论审核")
  @GetMapping("updateStatus")
  public Result updateStatus(Long id, Integer auditStatus) {
    
    service.updateStatus(id, auditStatus);
    
    return Result.ok();
  }
  
  @Operation(summary = "删除评论")
  @DeleteMapping("remove")
  public Result remove(Long id) {
    
    service.removeById(id);
    LambdaQueryWrapper<Comment> queryWrapper = new LambdaQueryWrapper<>();
    queryWrapper.eq(Comment::getTargetReplayId, id);
    service.remove(queryWrapper);
    
    return Result.ok();
  }
}
