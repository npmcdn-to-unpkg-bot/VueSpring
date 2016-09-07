package com.app.controller;

import com.app.model.HttpResponse;
import com.app.pojo.Doc;
import com.app.service.UserService;
import com.app.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.pojo.User;
import org.springframework.web.bind.annotation.ResponseBody;
import org.apache.commons.lang3.StringUtils;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by mosl on 16/8/25.
 */
@Controller
@RequestMapping("/user")
public class UserController extends Base{

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
            userService.insert(user);
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

    @RequestMapping("ftlTest")
    public String ftlTest(Map<String,Object> map){

        Doc doc = new Doc();
        doc.setName("good boy");
        doc.setmPath("this is path");
        doc.setmTime("2016-9-3");

        List<String> docs = new ArrayList<String>();
        docs.add("doc1");
        docs.add("doc2");
        doc.setDocs(docs);
        map.put("doc",doc);
        return "ftlTest";
    }

    @RequestMapping("/{id}")
    @ResponseBody
    public User getUser(@PathVariable("id") String uid){
        if(StringUtils.isBlank(uid)){
            throw new IllegalArgumentException("can't get uid");
        }
        return userService.find(uid);
    }

    @RequestMapping("/update/{id}")
    @ResponseBody
    public HttpResponse update(@PathVariable(value = "id") int uid,String password){
        if(StringUtils.isBlank(password)){
            throw new IllegalArgumentException("i");
        }
        return HttpResponse.SUCCESS(userService.update(uid,"password",password));
    }

}
