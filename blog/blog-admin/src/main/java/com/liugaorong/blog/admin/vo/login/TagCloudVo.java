package com.liugaorong.blog.admin.vo.login;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "标签云")
public class TagCloudVo {
  
  @Schema(description = "标签id")
  @TableField(value = "id")
  private Long id;
  
  @Schema(description = "标签名称")
  @TableField(value = "name")
  private String name;
}
