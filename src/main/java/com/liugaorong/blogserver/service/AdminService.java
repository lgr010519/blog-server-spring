package com.liugaorong.blogserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liugaorong.blogserver.dto.AdminLoginDTO;
import com.liugaorong.blogserver.pojo.Admin;
import com.liugaorong.blogserver.vo.Result;

/**
 * @author admin
 * @description 针对表【blog_admin】的数据库操作Service
 * @createDate 2024-04-26 15:30:49
 */
public interface AdminService extends IService<Admin> {

    Result login(AdminLoginDTO dto);
}
