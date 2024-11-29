package com.liugaorong.blog.admin.dto.article;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
@Schema(description = "文章管理分页查询dto")
public class ArticleQueryDto {
  
  @Schema(description = "文章标题")
  private String title;
  
  @Schema(description = "文章所属分类id")
  private String categoryIds;
  
  @Schema(description = "文章所属标签id列表")
  private String tagIds;
  
  @Schema(description = "启用状态 1启用 0停用")
  private Integer status;
  
  @Schema(description = "发布状态 1已发布 0未发布")
  private Integer publishStatus;
  
  @Schema(description = "创建时间")
  private List<String> createTime;
  
  @Schema(description = "更新时间")
  private List<String> updateTime;
}
