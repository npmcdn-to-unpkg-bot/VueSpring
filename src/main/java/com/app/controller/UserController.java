package com.app.controller;

import com.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.pojo.User;

import java.io.InputStream;
import java.util.Map;

/**
 * Created by mosl on 16/8/25.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(){
        return "index";
    }


    @RequestMapping("/register/{user}")
    public String register(@PathVariable("user")String userName){

        if(!StringUtils.isEmpty(userName)){
            User user = new User();
            user.setName(userName);
            user.setPassword("*");
            userService.insertUser(user);
        }
        return "index";
    }

    @RequestMapping("/test")
    public String test(Integer userId,@RequestBody InputStream inputStream){
        System.out.println("userId====>" + userId + inputStream);
        return "index";
    }

    @RequestMapping("index")
    public String Index(Map<String,Object> map){
        map.put("username","Hello world!");
        return "index";
    }
}
