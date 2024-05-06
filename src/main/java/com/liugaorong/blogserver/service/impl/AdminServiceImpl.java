package com.liugaorong.blogserver.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liugaorong.blogserver.dto.AdminLoginDTO;
import com.liugaorong.blogserver.mapper.AdminMapper;
import com.liugaorong.blogserver.pojo.Admin;
import com.liugaorong.blogserver.service.AdminService;
import com.liugaorong.blogserver.utils.JwtUtils;
import com.liugaorong.blogserver.utils.MD5Util;
import com.liugaorong.blogserver.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @author admin
 * @description 针对表【blog_admin】的数据库操作Service实现
 * @createDate 2024-04-26 15:30:49
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Result login(AdminLoginDTO dto) {

        //根据账号查询
        LambdaQueryWrapper<Admin> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Admin::getUsername, dto.getUsername());
        Admin admin = adminMapper.selectOne(queryWrapper);

        //判断账号
        if (admin == null) {
            return Result.error("账号不存在");
        }

        //判断密码
        if (StringUtils.isEmpty(dto.getPassword())) {
            return Result.error("密码不能为空");
        }
        if (!admin.getPassword().equals(MD5Util.encrypt(dto.getPassword()))) {
            return Result.error("密码错误");
        }

        //账号密码正确
        //根据用户唯一标识生成token
        String token = jwtUtils.createToken(Long.valueOf(admin.getId()));

        HashMap<String, String> data = new HashMap<>();
        data.put("token", token);
        data.put("username", dto.getUsername());

        return Result.success(data);
    }
}




