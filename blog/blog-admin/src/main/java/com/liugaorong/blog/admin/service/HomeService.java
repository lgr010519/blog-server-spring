package com.liugaorong.blog.admin.service;


import com.liugaorong.blog.admin.vo.user.UserGrowthVo;

import java.util.List;

public interface HomeService {
  
  List<UserGrowthVo> getUserGrowthList();
}
