package com.liugaorong.blog.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @TableName config_home
 */
@Schema(description = "首页配置表")
@TableName(value = "config_home")
@Data
public class ConfigHome extends BaseEntity {
  
  @Schema(description = "归档背景图片")
  @TableField(value = "archive_bg_url")
  private String archiveBgUrl;
  
  @Schema(description = "分类背景图片")
  @TableField(value = "categories_bg_url")
  private String categoriesBgUrl;
  
  @Schema(description = "分类详情背景图片")
  @TableField(value = "categories_detail_bg_url")
  private String categoriesDetailBgUrl;
  
  @Schema(description = "标签背景图片")
  @TableField(value = "tags_bg_url")
  private String tagsBgUrl;
  
  @Schema(description = "标签详情背景图片")
  @TableField(value = "tags_detail_bg_url")
  private String tagsDetailBgUrl;
  
  @Schema(description = "intro")
  @TableField(value = "introduction")
  private String introduction;
  
  private static final long serialVersionUID = 1L;
}