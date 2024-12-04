package com.liugaorong.blog.admin.vo.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "用户增长vo")
public class UserGrowthVo {
  
  @Schema(description = "时期")
  private String period;
  
  @Schema(description = "用户数量")
  private Long userNum;
}
