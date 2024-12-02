package com.liugaorong.blog.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liugaorong.blog.admin.vo.user.UserVo;
import com.liugaorong.blog.model.entity.User;

/**
 * @author admin
 * @description 针对表【user】的数据库操作Mapper
 * @createDate 2024-12-02 16:49:33
 * @Entity com.liugaorong.blog.model.entity.User
 */
public interface UserMapper extends BaseMapper<User> {
  
  Page<UserVo> getUserList(Page<UserVo> page, String nickName);
  
  Long selectArticleCount(Long userId);
}




