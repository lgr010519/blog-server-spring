package com.liugaorong.blog.admin.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liugaorong.blog.admin.mapper.CommentMapper;
import com.liugaorong.blog.admin.service.CommentService;
import com.liugaorong.blog.admin.vo.comment.CommentVo;
import com.liugaorong.blog.model.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author admin
 * @description 针对表【comment】的数据库操作Service实现
 * @createDate 2024-12-03 16:29:43
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment>
  implements CommentService {
  
  @Autowired
  private CommentMapper mapper;
  
  @Override
  public Page<CommentVo> getList(Page<CommentVo> page, String articleTitle, Integer auditStatus) {
    
    Page<CommentVo> commentVoPage = mapper.selectCommentPageList(page, articleTitle, auditStatus);
    
    for (CommentVo commentVo :
      commentVoPage.getRecords()) {
      if (commentVo.getTargetReplayId() != null) {
        String targetReplayContent = mapper.selectTargetReplayContent(commentVo.getTargetReplayId());
        commentVo.setTargetReplayContent(targetReplayContent);
      }
    }
    
    return commentVoPage;
  }
  
  @Override
  public void updateStatus(Long id, Integer auditStatus) {
    
    Date auditTime = new Date();
    mapper.updateStatus(id, auditStatus, auditTime);
  }
}




