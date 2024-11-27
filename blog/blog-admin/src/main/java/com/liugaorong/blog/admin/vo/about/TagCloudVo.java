package com.liugaorong.blog.admin.vo.about;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "标签云")
public class TagCloudVo {
  
  @Schema(description = "标签id")
  private Long id;
  
  @Schema(description = "标签名称")
  private String name;
}
