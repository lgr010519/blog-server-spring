package com.liugaorong.blogserver.interceptor;

import com.google.gson.Gson;
import com.liugaorong.blogserver.vo.Result;
import com.liugaorong.blogserver.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoginInterceptor implements HandlerInterceptor {
//    @Autowired
//    private Gson gson;
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        String token = request.getHeader("Token");
//        try {
//            JwtUtils.parseJwt(token);
//            return true;
//        } catch (Exception e) {
//            Result result = Result.error("NOT_LOGIN");
//            response.getWriter().write(gson.toJson(result));
//            return false;
//        }
//    }
}
