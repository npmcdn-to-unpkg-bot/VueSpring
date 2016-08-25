package com.app.controller;

import com.app.model.HttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jerry on 2016/8/24.
 * Home 主页
 */
@Controller
public class HomeController extends Base{

    @RequestMapping(value = "/index")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/user/{id}")
    @ResponseBody
    public List getUsers(@PathVariable(value = "id") String userId){
        List list = new ArrayList();
        list.add("hello");
        list.add(userId);
        return list;
    }

    @RequestMapping(value = "/hello")
    @ResponseBody
    public HttpResponse getHello(){
        List list = new ArrayList();
        list.add(30);
        list.add("hello boy!");
        return HttpResponse.SUCCESS(list);
    }

    @RequestMapping(value = "/hi")
    public String getHi(){
        getResponse().addCookie(new Cookie("sdfds","dsfdsf"));
        return "redirect:http://www.baidu.com";
    }


}
