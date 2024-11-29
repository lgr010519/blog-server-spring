package com.liugaorong.blog.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @TableName categories
 */
@Schema(description = "文章分类")
@TableName(value = "category")
@Data
public class Category extends BaseEntity {
  
  @Schema(description = "分类名称")
  @TableField(value = "name")
  private String name;
  
  private static final long serialVersionUID = 1L;
}