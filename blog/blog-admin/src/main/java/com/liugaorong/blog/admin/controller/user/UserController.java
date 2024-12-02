package com.liugaorong.blog.admin.controller.user;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liugaorong.blog.admin.service.UserService;
import com.liugaorong.blog.admin.vo.user.UserVo;
import com.liugaorong.blog.common.result.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Tag(name = "用户管理")
@RestController
@RequestMapping("/admin/user")
public class UserController {
  
  @Autowired
  private UserService service;
  
  @Operation(summary = "获取用户列表")
  @GetMapping("getList")
  public Result<IPage<UserVo>> getList(@RequestParam long current, @RequestParam long size, String nickName) {
    
    Page<UserVo> page = new Page<>(current, size);
    Page<UserVo> result = service.getList(page, nickName);
    
    return Result.ok(result);
  }
  
  @Operation(summary = "删除用户")
  @DeleteMapping("remove")
  public Result remove(@RequestParam Long id) {
    
    service.removeById(id);
    
    return Result.ok();
  }
}
