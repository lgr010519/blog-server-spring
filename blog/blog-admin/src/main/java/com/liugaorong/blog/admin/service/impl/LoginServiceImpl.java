package com.liugaorong.blog.admin.service.impl;

import com.liugaorong.blog.admin.mapper.SystemUserMapper;
import com.liugaorong.blog.admin.service.LoginService;
import com.liugaorong.blog.admin.vo.login.CaptchaVo;
import com.liugaorong.blog.admin.vo.login.LoginVo;
import com.liugaorong.blog.common.constant.RedisConstant;
import com.liugaorong.blog.common.exception.BlogException;
import com.liugaorong.blog.common.result.ResultCodeEnum;
import com.liugaorong.blog.common.utils.JwtUtil;
import com.liugaorong.blog.model.entity.SystemUser;
import com.liugaorong.blog.model.enums.BaseStatus;
import com.wf.captcha.SpecCaptcha;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class LoginServiceImpl implements LoginService {
  
  
  @Autowired
  private StringRedisTemplate stringRedisTemplate;
  
  @Autowired
  private SystemUserMapper systemUserMapper;
  
  @Override
  public CaptchaVo getCaptcha() {
    
    SpecCaptcha specCaptcha = new SpecCaptcha(130, 32, 4);
    
    String key = RedisConstant.ADMIN_LOGIN_PREFIX + UUID.randomUUID();
    String value = specCaptcha.text().toLowerCase();
    
    stringRedisTemplate.opsForValue().set(key, value, RedisConstant.ADMIN_LOGIN_CAPTCHA_TTL_SEC, TimeUnit.SECONDS);
    
    return new CaptchaVo(specCaptcha.toBase64(), key);
  }
  
  @Override
  public String login(LoginVo loginVo) {
    
    if (!StringUtils.hasLength(loginVo.getCaptchaCode())) {
      throw new BlogException(ResultCodeEnum.ADMIN_CAPTCHA_CODE_NOT_FOUND);
    }
    
    String code = stringRedisTemplate.opsForValue().get(loginVo.getCaptchaKey());
    if (!StringUtils.hasLength(code)) {
      throw new BlogException(ResultCodeEnum.ADMIN_CAPTCHA_CODE_EXPIRED);
    }
    
    if (!code.equals(loginVo.getCaptchaCode().toLowerCase())) {
      throw new BlogException(ResultCodeEnum.ADMIN_CAPTCHA_CODE_ERROR);
    }
    
    SystemUser systemUser = systemUserMapper.selectOneByUsername(loginVo.getUsername());
    
    if (systemUser == null) {
      throw new BlogException(ResultCodeEnum.ADMIN_ACCOUNT_NOT_EXIST_ERROR);
    }
    
    if (Objects.equals(systemUser.getStatus(), BaseStatus.DISABLE.getCode())) {
      throw new BlogException(ResultCodeEnum.ADMIN_ACCOUNT_DISABLED_ERROR);
    }
    
    if (!systemUser.getPassword().equals(DigestUtils.md5Hex(loginVo.getPassword()))) {
      throw new BlogException(ResultCodeEnum.ADMIN_ACCOUNT_ERROR);
    }
    
    //创建JWT
    return JwtUtil.createToken(systemUser.getId(), systemUser.getUsername());
  }
  
  @Override
  public SystemUser getUserInfoById(Long userId) {
    
    return systemUserMapper.selectById(userId);
  }
}
