package com.liugaorong.blog.admin.vo.login;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "介绍图片")
public class AboutImgVo {
  
  @Schema(description = "介绍图片id")
  @TableField(value = "id")
  private Long id;
  
  @Schema(description = "图片地址")
  @TableField(value = "img_url")
  private String imgUrl;
}
