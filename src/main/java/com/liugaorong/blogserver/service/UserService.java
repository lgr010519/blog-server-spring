package com.liugaorong.blogserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liugaorong.blogserver.dto.UserLoginDTO;
import com.liugaorong.blogserver.pojo.User;
import com.liugaorong.blogserver.vo.Result;

/**
 * @author admin
 * @description 针对表【news_user】的数据库操作Service
 * @createDate 2024-04-25 17:07:38
 */
public interface UserService extends IService<User> {

    Result login(UserLoginDTO dto);
}
