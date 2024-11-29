package com.liugaorong.blog.admin.dto.article;

import com.liugaorong.blog.model.entity.Article;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
@Schema(description = "文章管理dto")
public class ArticleDto extends Article {
  
  @Schema(description = "文章所属标签id列表")
  private List<Long> tagIdList;
}
