package com.liugaorong.blog.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BaseEntity implements Serializable {
  
  @Schema(description = "主键")
  @TableId(value = "id", type = IdType.AUTO)
  private Long id;
  
  @Schema(description = "创建时间")
  @TableField(value = "create_time", fill = FieldFill.INSERT)
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date createTime;
  
  @Schema(description = "更新时间")
  @TableField(value = "update_time", fill = FieldFill.UPDATE)
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date updateTime;
  
  @Schema(description = "乐观锁")
  @JsonIgnore
  @TableField("version")
  private Integer version;
  
  @Schema(description = "逻辑删除")
  @JsonIgnore
  @TableLogic
  @TableField("is_deleted")
  private Byte isDeleted;
  
}