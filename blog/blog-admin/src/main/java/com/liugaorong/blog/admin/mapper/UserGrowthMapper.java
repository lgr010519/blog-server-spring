package com.liugaorong.blog.admin.mapper;

import java.time.LocalDateTime;

public interface UserGrowthMapper {
  
  Long getUserNum(LocalDateTime periodStart, LocalDateTime periodEnd);
}
