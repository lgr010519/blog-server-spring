package com.liugaorong.blog.admin.vo.about;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "介绍图片")
public class AboutImgVo {
  
  @Schema(description = "介绍图片id")
  private Long id;
  
  @Schema(description = "图片地址")
  private String imgUrl;
}
