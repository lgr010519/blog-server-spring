package com.liugaorong.blog.admin.vo.article;

import com.liugaorong.blog.model.entity.BaseEntity;
import com.liugaorong.blog.model.entity.Tags;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
@Schema(description = "文章vo")
public class ArticleVo extends BaseEntity {
  
  @Schema(description = "文章标题")
  private String title;
  
  @Schema(description = "文章封面")
  private String cover;
  
  @Schema(description = "文章简介")
  private String introduction;
  
  @Schema(description = "分类id")
  private Long categoryId;
  
  @Schema(description = "分类名称")
  private String categoryName;
  
  @Schema(description = "标签列表")
  private List<Tags> tagsList;
  
  @Schema(description = "查看数量")
  private Long views;
  
  @Schema(description = "评论数量")
  private Long comment;
  
  @Schema(description = "点赞数量")
  private Long like;
  
  @Schema(description = "收藏数量")
  private Long collect;
  
  @Schema(description = "启用状态 1启用 0停用")
  private Integer status;
  
  @Schema(description = "发布状态 1已发布 0未发布")
  private Integer publishStatus;
}
