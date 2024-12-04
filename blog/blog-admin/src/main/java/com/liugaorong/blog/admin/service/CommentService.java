package com.liugaorong.blog.admin.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.liugaorong.blog.admin.vo.comment.CommentVo;
import com.liugaorong.blog.model.entity.Comment;

/**
 * @author admin
 * @description 针对表【comment】的数据库操作Service
 * @createDate 2024-12-03 16:29:43
 */
public interface CommentService extends IService<Comment> {
  
  Page<CommentVo> getList(Page<CommentVo> page, String articleTitle, Integer auditStatus);
  
  void updateStatus(Long id, Integer auditStatus);
}
