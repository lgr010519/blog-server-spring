package com.liugaorong.blog.admin.controller.about;

import com.liugaorong.blog.admin.service.AboutService;
import com.liugaorong.blog.admin.vo.login.AboutVo;
import com.liugaorong.blog.common.result.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
