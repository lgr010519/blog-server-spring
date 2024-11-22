package com.liugaorong.blog.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liugaorong.blog.model.entity.SystemUser;

/**
 * @author admin
 * @description 针对表【system_user(员工信息表)】的数据库操作Mapper
 * @createDate 2024-11-21 16:29:55
 * @Entity com.liugaorong.blog.admin.SystemUser
 */
public interface SystemUserMapper extends BaseMapper<SystemUser> {
  
  SystemUser selectOneByUsername(String username);
}




