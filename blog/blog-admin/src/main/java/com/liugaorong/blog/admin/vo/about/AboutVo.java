package com.liugaorong.blog.admin.vo.about;

import com.liugaorong.blog.model.entity.About;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
@Schema(description = "关于详情")
public class AboutVo extends About {
  
  @Schema(description = "标签云")
  private List<TagCloudVo> tagCloudList;
  
  @Schema(description = "介绍图片")
  private List<AboutImgVo> aboutImgList;
}
