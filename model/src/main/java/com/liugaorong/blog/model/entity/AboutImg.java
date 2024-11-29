package com.liugaorong.blog.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @TableName about_img
 */
@Schema(description = "介绍图片")
@TableName(value = "about_img")
@Data
public class AboutImg extends BaseEntity {
  
  @Schema(description = "图片地址")
  @TableField(value = "img_url")
  private String imgUrl;
  
  @Schema(description = "关于id")
  @TableField(value = "about_id")
  private Long aboutId;
  
  private static final long serialVersionUID = 1L;
}