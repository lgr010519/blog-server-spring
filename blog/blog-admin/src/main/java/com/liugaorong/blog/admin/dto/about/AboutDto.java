package com.liugaorong.blog.admin.dto.about;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
@Schema(description = "关于管理dto")
public class AboutDto {
  
  @Schema(description = "关于id")
  private Long id;
  
  @Schema(description = "详细介绍")
  private String description;
  
  @Schema(description = "介绍图片列表")
  private List<String> aboutImgList;
  
  @Schema(description = "标签云列表")
  private List<String> tagCloudList;
}
