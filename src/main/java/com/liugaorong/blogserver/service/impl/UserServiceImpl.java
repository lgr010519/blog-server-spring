package com.liugaorong.blogserver.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liugaorong.blogserver.dto.UserLoginDTO;
import com.liugaorong.blogserver.mapper.UserMapper;
import com.liugaorong.blogserver.pojo.User;
import com.liugaorong.blogserver.service.UserService;
import com.liugaorong.blogserver.utils.JwtUtils;
import com.liugaorong.blogserver.utils.MD5Util;
import com.liugaorong.blogserver.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author admin
 * @description 针对表【news_user】的数据库操作Service实现
 * @createDate 2024-04-25 17:07:38
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private UserMapper userMapper;

    @Override
    public Result login(UserLoginDTO dto) {

        //根据账号查询
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername, dto.getUsername());
        User loginUser = userMapper.selectOne(queryWrapper);

        //判断账号
        if (loginUser == null) {
            return Result.error("账号不存在");
        }

        //判断密码
        if (StringUtils.isEmpty(dto.getUserPwd())) {
            return Result.error("密码不能为空");
        }
        if (!loginUser.getUserPwd().equals(MD5Util.encrypt(dto.getUserPwd()))) {
            return Result.error("密码错误");
        }

        //账号密码正确
        //根据用户唯一标识生成token
        String token = jwtUtils.createToken(Long.valueOf(loginUser.getUid()));

        return Result.success(token);
    }
}




