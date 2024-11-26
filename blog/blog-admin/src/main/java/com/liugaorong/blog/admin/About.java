package com.liugaorong.blog.admin;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.liugaorong.blog.model.entity.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @TableName about
 */
@Schema(description = "关于表")
@TableName(value = "about")
@Data
public class About extends BaseEntity {
  
  @Schema(description = "详细介绍")
  @TableField(value = "description")
  private String description;
  
  private static final long serialVersionUID = 1L;
}