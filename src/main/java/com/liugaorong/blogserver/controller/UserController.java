package com.liugaorong.blogserver.controller;

import com.liugaorong.blogserver.dto.UserLoginDTO;
import com.liugaorong.blogserver.service.UserService;
import com.liugaorong.blogserver.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("login")
    public Result login(@RequestBody UserLoginDTO dto) {
        return userService.login(dto);
    }
}
