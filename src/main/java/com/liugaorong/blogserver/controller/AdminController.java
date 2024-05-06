package com.liugaorong.blogserver.controller;

import com.liugaorong.blogserver.dto.AdminLoginDTO;
import com.liugaorong.blogserver.service.AdminService;
import com.liugaorong.blogserver.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admin")
@CrossOrigin
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("login")
    public Result login(@RequestBody AdminLoginDTO dto) {
        return adminService.login(dto);
    }
}
