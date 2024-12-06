package com.liugaorong.blog.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @TableName config_hf
 */
@Schema(description = "Header/Footer配置表")
@TableName(value = "config_hf")
@Data
public class ConfigHf extends BaseEntity {
  
  @Schema(description = "是否开启搜索")
  @TableField(value = "search_status")
  private Integer searchStatus;
  
  @Schema(description = "是否开启登录")
  @TableField(value = "login_status")
  private Integer loginStatus;
  
  @Schema(description = "是否开启注册")
  @TableField(value = "register_status")
  private Integer registerStatus;
  
  @Schema(description = "logo类型 1图片 2文本")
  @TableField(value = "logo_type")
  private Integer logoType;
  
  @Schema(description = "logo图片")
  @TableField(value = "logo_img")
  private String logoImg;
  
  @Schema(description = "logo文本")
  @TableField(value = "logo_text")
  private String logoText;
  
  @Schema(description = "copyright")
  @TableField(value = "copyright")
  private String copyright;
  
  @Schema(description = "额外信息")
  @TableField(value = "extra")
  private String extra;
  
  private static final long serialVersionUID = 1L;
}