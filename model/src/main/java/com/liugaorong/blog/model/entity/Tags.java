package com.liugaorong.blog.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @TableName tag
 */
@Schema(description = "文章标签")
@TableName(value = "tag")
@Data
public class Tags extends BaseEntity {
  @Schema(description = "标签名称")
  @TableField(value = "name")
  private String name;
  
  @Schema(description = "文章数量")
  @TableField(value = "article_num")
  private Long articleNum;
  
  @Schema(description = "标签状态")
  @TableField(value = "status")
  private Integer status;
  
  private static final long serialVersionUID = 1L;
}