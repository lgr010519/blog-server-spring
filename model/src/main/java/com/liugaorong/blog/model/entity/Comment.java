package com.liugaorong.blog.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

/**
 * @TableName comment
 */
@Schema(description = "评论表")
@TableName(value = "comment")
@Data
public class Comment extends BaseEntity {
  
  @Schema(description = "目标回复ID")
  @TableField(value = "target_replay_id")
  private Long targetReplayId;
  
  @Schema(description = "当前回复内容")
  @TableField(value = "current_replay_content")
  private String currentReplayContent;
  
  @Schema(description = "审核时间")
  @TableField(value = "audit_time")
  private Date auditTime;
  
  @Schema(description = "审核状态")
  @TableField(value = "audit_status")
  private Integer auditStatus;
  
  @Schema(description = "用户id")
  @TableField(value = "user_id")
  private Long userId;
  
  @Schema(description = "文章id")
  @TableField(value = "article_id")
  private Long articleId;
  
  private static final long serialVersionUID = 1L;
}