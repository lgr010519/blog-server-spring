package com.liugaorong.blog.admin.vo.category;

import com.liugaorong.blog.model.entity.Category;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "分类vo")
public class CategoryVo extends Category {
  
  @Schema(description = "该分类下的文章数量")
  private Long articleNum;
}
