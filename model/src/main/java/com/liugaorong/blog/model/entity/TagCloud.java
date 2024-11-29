package com.liugaorong.blog.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @TableName tag_cloud
 */
@Schema(description = "标签云")
@TableName(value = "tag_cloud")
@Data
public class TagCloud extends BaseEntity {
  
  @Schema(description = "标签名称")
  @TableField(value = "name")
  private String name;
  
  @Schema(description = "关于id")
  @TableField(value = "about_id")
  private Integer aboutId;
  
  private static final long serialVersionUID = 1L;
}