package com.liugaorong.blog.admin.controller.home;

import com.liugaorong.blog.admin.service.HomeService;
import com.liugaorong.blog.admin.vo.user.UserGrowthVo;
import com.liugaorong.blog.common.result.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "首页")
@RestController
@RequestMapping("/admin/home")
public class HomeController {
  
  @Autowired
  private HomeService service;
  
  @Operation(summary = "获取近半年用户增长列表")
  @GetMapping("getUserGrowthList")
  public Result<List<UserGrowthVo>> getList() {
    
    List<UserGrowthVo> result = service.getUserGrowthList();
    
    return Result.ok(result);
  }
}
