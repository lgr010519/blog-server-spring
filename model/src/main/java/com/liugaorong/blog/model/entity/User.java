package com.liugaorong.blog.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @TableName user
 */
@Schema(description = "用户表")
@TableName(value = "user")
@Data
public class User extends BaseEntity {
  
  @Schema(description = "昵称")
  @TableField(value = "nick_name")
  private String nickName;
  
  @Schema(description = "头像")
  @TableField(value = "avatar")
  private String avatar;
  
  @Schema(description = "来源")
  @TableField(value = "provider")
  private String provider;
  
  @Schema(description = "邮箱")
  @TableField(value = "email")
  private String email;
  
  @Schema(description = "简介")
  @TableField(value = "introduction")
  private String introduction;
  
  private static final long serialVersionUID = 1L;
}