package com.app.controller;

import com.app.annotation.Authorization;
import com.app.cache.CacheHandler;
import com.app.model.HttpResponse;
import com.app.pojo.Pass;
import com.app.pojo.User;
import com.app.repo.CacheRepo;
import com.app.repo.PassRepo;
import com.app.repo.UserRepo;
import com.app.util.MongoIDGenerator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.jdbc.core.JdbcTemplate;
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

    private static Logger logger = Logger.getLogger(HomeController.class);
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PassRepo passRepo;
    @Autowired
    private CacheRepo cacheRepo;
    @Autowired
    private MongoDbFactory mongoDbFactory;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping(value = "/index")
    public String index(){
        return "index";
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

    @RequestMapping(value = "/repo")
    public String repo(){

        User user = new User();
        user.setName("hello boy");
        User user1 = userRepo.save(user);

        System.out.println(""+ user1);
        if(userRepo.exists("sdfsd")){
            System.out.println("exist");
        } else {
            System.out.println("not exist");
        }
        return "index";
    }

    @RequestMapping(value = "/redis")
    public String redis(){

        Pass pass = new Pass();
        pass.setPass("hello");
        pass.setGoods("家具");
        passRepo.set("key",pass);
        return "index";
    }


    @RequestMapping(value = "/cache")
    public String hello(){

        List<String> stringList = new ArrayList<String>();
        for(int i=0;i< 100;i++){
            stringList.add(" ====> " + i);
        }
        cacheRepo.set("list3",stringList,5);

        return "index";
    }

    @RequestMapping("/generate")
    @Authorization
    public String generate(){

        MongoIDGenerator mongoIDGenerator = new MongoIDGenerator(mongoDbFactory.getDb(),1);
        long id = mongoIDGenerator.generateId("ids");
        System.out.println(" " + id);
        return "index";
    }

    @RequestMapping("/mapping")
    public String mapping(){

        logger.info("haha im test");
        return "index";
    }

    @RequestMapping("/jdbc")
    public String jdbc(){
        jdbcTemplate.execute("create table person(name varchar(20),password VARCHAR(20))");
        return "index";
    }

}
