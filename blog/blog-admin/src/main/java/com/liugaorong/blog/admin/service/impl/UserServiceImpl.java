package com.liugaorong.blog.admin.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liugaorong.blog.admin.mapper.UserMapper;
import com.liugaorong.blog.admin.service.UserService;
import com.liugaorong.blog.admin.vo.user.UserVo;
import com.liugaorong.blog.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author admin
 * @description 针对表【user】的数据库操作Service实现
 * @createDate 2024-12-02 16:49:33
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
  implements UserService {
  
  @Autowired
  private UserMapper mapper;
  
  @Override
  public Page<UserVo> getList(Page<UserVo> page, String nickName) {
    
    Page<UserVo> userVoPage = mapper.getUserList(page, nickName);
    for (UserVo userVo :
      userVoPage.getRecords()) {
      Long articleNum = mapper.selectArticleCount(userVo.getId());
      userVo.setArticleNum(articleNum);
    }
    
    return userVoPage;
  }
}




