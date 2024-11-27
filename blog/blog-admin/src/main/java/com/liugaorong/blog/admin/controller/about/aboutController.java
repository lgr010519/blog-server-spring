package com.liugaorong.blog.admin.controller.about;

import com.liugaorong.blog.admin.dto.about.AboutDto;
import com.liugaorong.blog.admin.service.AboutService;
import com.liugaorong.blog.admin.vo.about.AboutVo;
import com.liugaorong.blog.common.result.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "关于管理")
@RestController
@RequestMapping("/admin/about")
public class aboutController {
  
  @Autowired
  private AboutService service;
  
  @Operation(summary = "关于列表")
  @GetMapping("getList")
  public Result<List<AboutVo>> getList() {
    
    List<AboutVo> result = service.getList();
    
    return Result.ok(result);
  }
  
  @Operation(summary = "更新关于信息")
  @PostMapping("saveOrUpdate")
  public Result saveOrUpdate(@RequestBody AboutDto aboutDto) {
    
    service.saveOrUpdateAbout(aboutDto);
    
    return Result.ok();
  }
}
