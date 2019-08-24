package com.neverend.blog.contoller.color;

import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.annotations.ApiIgnore;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@ApiIgnore
@Controller
public class color {

    @RequestMapping("/bl")
    public String bolck(){
        return "admin/color/bol/index";
    }


    @RequestMapping("/admin")
    public String zblogin(){
        return "admin/color/login";
    }

    @RequestMapping("/map/demo")
    public String map(){
        return "admin/color/bol/map";
    }

    @RequestMapping("/test/table/demo1")
    @ResponseBody
    public String bolckjson(@RequestParam(required = false,defaultValue = "1",name = "page") String page,
                            @RequestParam(required = false,defaultValue = "2",name = "limit") String limit){
        User user1 = new User("1","23","34","4","45","45","45","45","er",new Date());
        User user2 = new User("2","23","34","459","45","45","45","45","er",new Date());
        User user3 = new User("3","23","34","345","45","45","45","45","er",new Date());
        User user4 = new User("4","23","34","45","45","45","45","45","er",new Date());
        User user5 = new User("5","23","34","55","45","45","45","45","er",new Date());
        User user6 = new User("6","23","34","15","45","45","45","45","er",new Date());
        User user7 = new User("7","23","34","40","45","45","45","45","er",new Date());
        User user8 = new User("8","23","34","49","45","45","45","45","er",new Date());
        User user9 = new User("9","23","34","40","45","45","45","45","er",new Date());
        User user10 = new User("10","23","34","49","45","45","45","45","er",new Date());
        User user11 = new User("11","23","34","40","45","45","45","45","er",new Date());
        User user12 = new User("12","23","34","49","45","45","45","45","er",new Date());
        User user13 = new User("13","23","34","40","45","45","45","45","er",new Date());
        User user14 = new User("14","23","34","49","45","45","45","45","er",new Date());
        List<User> users = new ArrayList<>();
        if (limit.equals("10")){
            if(page.equals("1")){
                users.add(user1);
                users.add(user2);
                users.add(user3);
                users.add(user4);
                users.add(user5);
                users.add(user6);
                users.add(user7);
                users.add(user8);
                users.add(user9);
                users.add(user10);
            }else if (page.equals("2")){
                users.add(user11);
                users.add(user12);
                users.add(user13);
                users.add(user14);
            }else {

            }
        }else {
            if (page.equals("1")){
                users.add(user1);
                users.add(user2);
                users.add(user3);
                users.add(user4);
                users.add(user5);
                users.add(user6);
                users.add(user7);
                users.add(user8);
                users.add(user9);
                users.add(user10);
                users.add(user11);
                users.add(user12);
                users.add(user13);
                users.add(user14);
            }else {
            }
        }


        test test = new test(0,"",14,users);
        Gson gson = new Gson();
        return gson.toJson(test);

    }
    @RequestMapping("/gree")
    public String gree(){
        return "admin/color/gr/index";
    }

    @RequestMapping("/gree/cyan")
    public String greecyan(){
        return "admin/color/grcyan/index";
    }

    @RequestMapping("/cyan")
    public String cgray(){
        return "admin/color/cyan/index";
    }

    @RequestMapping("/blue")
    public String blue(){
        return "admin/color/blue/index";
    }
    @RequestMapping("/blue/left")
    public String blueleft(){
        return "admin/color/blueleft/index";
    }
}
