package com.liugaorong.blog.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liugaorong.blog.admin.vo.comment.CommentVo;
import com.liugaorong.blog.model.entity.Comment;

/**
 * @author admin
 * @description 针对表【comment】的数据库操作Mapper
 * @createDate 2024-12-03 16:29:43
 * @Entity com.liugaorong.blog.model.entity.Comment
 */
public interface CommentMapper extends BaseMapper<Comment> {
  
  Page<CommentVo> selectCommentPageList(Page<CommentVo> page, String articleTitle, Integer auditStatus);
  
  String selectTargetReplayContent(Long id);
}




