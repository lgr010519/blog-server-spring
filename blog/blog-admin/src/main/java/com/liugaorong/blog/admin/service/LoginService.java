package com.liugaorong.blog.admin.service;

import com.liugaorong.blog.admin.vo.login.CaptchaVo;
import com.liugaorong.blog.admin.vo.login.LoginVo;
import com.liugaorong.blog.model.entity.SystemUser;

public interface LoginService {
  
  CaptchaVo getCaptcha();
  
  String login(LoginVo loginVo);
  
  SystemUser getUserInfoById(Long userId);
}
