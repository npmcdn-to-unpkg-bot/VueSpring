package com.app.controller;

import com.app.model.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by moslpc on 2016/8/24.
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
    public Response getHello(){

        List list = new ArrayList();
        list.add(30);
        list.add("hello boy!");
        return Response.SUCCESS(list);
    }
}
