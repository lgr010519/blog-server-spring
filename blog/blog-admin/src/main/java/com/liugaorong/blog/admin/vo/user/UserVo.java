package com.liugaorong.blog.admin.vo.user;

import com.liugaorong.blog.model.entity.User;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "用户vo")
public class UserVo extends User {
  
  @Schema(description = "用户收藏文章数量")
  private Long articleNum;
}
