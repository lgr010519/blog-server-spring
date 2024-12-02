package com.liugaorong.blog.admin.vo.article;

import com.liugaorong.blog.model.entity.Article;
import com.liugaorong.blog.model.entity.Tags;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
@Schema(description = "文章详情vo")
public class ArticleDetailVo extends Article {
  
  @Schema(description = "标签列表")
  private List<Tags> tagsList;
}
