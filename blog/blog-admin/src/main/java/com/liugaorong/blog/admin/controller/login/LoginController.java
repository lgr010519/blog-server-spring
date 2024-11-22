package com.liugaorong.blog.admin.controller.login;

import com.liugaorong.blog.admin.service.LoginService;
import com.liugaorong.blog.admin.vo.login.CaptchaVo;
import com.liugaorong.blog.admin.vo.login.LoginVo;
import com.liugaorong.blog.common.login.LoginUserHolder;
import com.liugaorong.blog.common.result.Result;
import com.liugaorong.blog.model.entity.SystemUser;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Tag(name = "登录管理")
@RestController
@RequestMapping("/admin")
public class LoginController {
  
  @Autowired
  private LoginService service;
  
  @Operation(summary = "获取图形验证码")
  @GetMapping("login/captcha")
  public Result<CaptchaVo> getCaptcha() {
    CaptchaVo captchaVo = service.getCaptcha();
    return Result.ok(captchaVo);
  }
  
  @Operation(summary = "登录")
  @PostMapping("login")
  public Result<String> login(@RequestBody LoginVo loginVo) {
    String jwt = service.login(loginVo);
    return Result.ok(jwt);
  }
  
  @Operation(summary = "获取登陆用户个人信息")
  @GetMapping("userInfo")
  public Result<SystemUser> info() {
    Long userId = LoginUserHolder.getLoginUser().getUserId();
    SystemUser systemUser = service.getUserInfoById(userId);
    return Result.ok(systemUser);
  }
}