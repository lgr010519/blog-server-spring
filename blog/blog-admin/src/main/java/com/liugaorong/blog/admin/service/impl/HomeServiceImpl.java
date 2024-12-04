package com.liugaorong.blog.admin.service.impl;

import com.liugaorong.blog.admin.mapper.UserGrowthMapper;
import com.liugaorong.blog.admin.service.HomeService;
import com.liugaorong.blog.admin.vo.user.UserGrowthVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class HomeServiceImpl implements HomeService {
  
  @Autowired
  private UserGrowthMapper mapper;
  
  @Override
  public List<UserGrowthVo> getUserGrowthList() {
    
    LocalDateTime periodStart = LocalDateTime.now();
    LocalDateTime periodEnd = periodStart.minusMonths(1);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    
    List<UserGrowthVo> userGrowthVoList = new ArrayList<>();
    
    for (int i = 0; i < 6; i++) {
      String formatPeriodStart = periodStart.format(formatter);
      String formatPeriodEnd = periodEnd.format(formatter);
      
      UserGrowthVo userGrowthVo = new UserGrowthVo();
      
      userGrowthVo.setPeriod(formatPeriodEnd + " " + formatPeriodStart);
      
      Long userNum = mapper.getUserNum(periodEnd, periodStart);
      userGrowthVo.setUserNum(userNum);
      
      userGrowthVoList.add(userGrowthVo);
      
      periodStart = periodStart.minusMonths(1);
      periodEnd = periodEnd.minusMonths(1);
    }
    
    return userGrowthVoList;
  }
}
