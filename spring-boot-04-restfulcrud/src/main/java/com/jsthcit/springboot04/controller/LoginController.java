package com.jsthcit.springboot04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {
    //处理的请求的地址
    @PostMapping(value = "/user/login")
    public String Login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String, Object> map, HttpSession session) {
         if (/*!StringUtils.isEmpty(username)*/ "root".equals(username) &&"root".equals(password)) {
            //防止重复提交表单 用重定向
            session.setAttribute("loginUser", username);
            return "redirect:/main.html";
        }else {
            map.put("msg", "用户名密码错误");
            return "login";
        }

    }
}
