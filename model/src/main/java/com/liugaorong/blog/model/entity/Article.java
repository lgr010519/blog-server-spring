package com.liugaorong.blog.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @TableName article
 */
@Schema(description = "文章表")
@TableName(value = "article")
@Data
public class Article extends BaseEntity {
  
  @Schema(description = "文章标题")
  @TableField(value = "title")
  private String title;
  
  @Schema(description = "文章简介")
  @TableField(value = "introduction")
  private String introduction;
  
  @Schema(description = "文章封面")
  @TableField(value = "cover")
  private String cover;
  
  @Schema(description = "分类id")
  @TableField(value = "category_id")
  private Long categoryId;
  
  @Schema(description = "是否开启评论 1开启 0关闭")
  @TableField(value = "is_comment")
  private Integer isComment;
  
  @Schema(description = "是否开启点赞 1开启 0关闭")
  @TableField(value = "is_like")
  private Integer isLike;
  
  @Schema(description = "是否开启收藏 1开启 0关闭")
  @TableField(value = "is_collect")
  private Integer isCollect;
  
  @Schema(description = "查看数量")
  @TableField(value = "views")
  private Long views;
  
  @Schema(description = "点赞数量")
  @TableField(value = "like")
  private Long like;
  
  @Schema(description = "收藏数量")
  @TableField(value = "collect")
  private Long collect;
  
  @Schema(description = "评论数量")
  @TableField(value = "comment")
  private Long comment;
  
  @Schema(description = "启用状态 1启用 0停用")
  @TableField(value = "status")
  private Integer status;
  
  @Schema(description = "发布状态 1已发布 0未发布")
  @TableField(value = "publish_status")
  private Integer publishStatus;
  
  @Schema(description = "文章内容")
  @TableField(value = "content")
  private String content;
  
  private static final long serialVersionUID = 1L;
}