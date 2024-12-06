package com.liugaorong.blog.admin.controller.config;

import com.liugaorong.blog.admin.service.ConfigHfService;
import com.liugaorong.blog.admin.service.ConfigHomeService;
import com.liugaorong.blog.common.result.Result;
import com.liugaorong.blog.model.entity.ConfigHf;
import com.liugaorong.blog.model.entity.ConfigHome;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "配置管理")
@RestController
@RequestMapping("/admin/config")
public class ConfigController {
  
  @Autowired
  private ConfigHomeService configHomeService;
  
  @Autowired
  private ConfigHfService configHfService;
  
  @Operation(summary = "获取首页配置数据")
  @GetMapping("home/getData")
  public Result<ConfigHome> getHomeConfigData() {
    
    List<ConfigHome> list = configHomeService.list();
    
    ConfigHome result;
    
    if (list.isEmpty()) {
      result = null;
    } else {
      result = list.get(0);
    }
    
    return Result.ok(result);
  }
  
  @Operation(summary = "添加或修改首页配置")
  @PostMapping("home/saveOrUpdate")
  public Result saveOrUpdateHomeConfig(@RequestBody ConfigHome configHome) {
    
    configHomeService.saveOrUpdate(configHome);
    
    return Result.ok();
  }
  
  @Operation(summary = "获取Header/Footer配置数据")
  @GetMapping("hf/getData")
  public Result<ConfigHf> getHfConfigData() {
    
    List<ConfigHf> list = configHfService.list();
    
    ConfigHf result;
    
    if (list.isEmpty()) {
      result = null;
    } else {
      result = list.get(0);
    }
    
    return Result.ok(result);
  }
  
  @Operation(summary = "添加或修改Header/Footer配置")
  @PostMapping("hf/saveOrUpdate")
  public Result saveOrUpdateHfConfig(@RequestBody ConfigHf configHf) {
    
    configHfService.saveOrUpdate(configHf);
    
    return Result.ok();
  }
}
