package com.liugaorong.blog.admin.vo.comment;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

@Data
@Schema(description = "评论vo")
public class CommentVo {
  
  @Schema(description = "评论id")
  private Long id;
  
  @Schema(description = "文章标题")
  private String articleTitle;
  
  @Schema(description = "昵称")
  private String nickName;
  
  @Schema(description = "当前回复内容")
  private String currentReplayContent;
  
  @Schema(description = "目标回复id")
  private Long targetReplayId;
  
  @Schema(description = "目标回复内容")
  private String targetReplayContent;
  
  @Schema(description = "审核状态")
  private Integer auditStatus;
  
  @Schema(description = "评论时间")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date commentTime;
  
  @Schema(description = "审核时间")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date auditTime;
}
