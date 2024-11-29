package com.liugaorong.blog.admin.vo.tags;

import com.liugaorong.blog.model.entity.Tags;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "标签vo")
public class TagsVo extends Tags {
  
  @Schema(description = "该标签下的文章数量")
  private Long articleNum;
}
