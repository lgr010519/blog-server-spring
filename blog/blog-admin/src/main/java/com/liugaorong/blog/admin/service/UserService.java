package com.liugaorong.blog.admin.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.liugaorong.blog.admin.vo.user.UserVo;
import com.liugaorong.blog.model.entity.User;

/**
 * @author admin
 * @description 针对表【user】的数据库操作Service
 * @createDate 2024-12-02 16:49:33
 */
public interface UserService extends IService<User> {
  
  Page<UserVo> getList(Page<UserVo> page, String nickName);
}
