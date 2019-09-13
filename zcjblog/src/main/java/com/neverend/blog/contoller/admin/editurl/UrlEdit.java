package com.neverend.blog.contoller.admin.editurl;

import com.neverend.blog.moudel.Msg;
import com.neverend.blog.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.annotations.ApiIgnore;


@Controller
@ApiIgnore
public class UrlEdit {

    @Autowired
    RolePermissionService rolePermissionService;

    @GetMapping("/system/admin/sel/url")
    public String urledit(){
        return "admin/security/setsecurity";
    }

    @GetMapping("/system/admin/editurl")
    @ResponseBody
    public Msg urleditjs(@RequestParam(name = "page",defaultValue = "1",required = false) Integer page,
                         @RequestParam(name = "limit",defaultValue = "10",required = false) Integer limit){
        Msg msg = rolePermissionService.findAllPermissionMsg(page,limit);
        return msg;
    }


    @PostMapping("/system/admin/open/close")
    @ResponseBody
    public Msg openCloseurl(@RequestParam(name = "iskq",defaultValue = "false",required = false) boolean iskq,
                         @RequestParam(name = "id") String id,
                         @RequestParam(name = "secrityName")   String secrityName){
        Msg msg = rolePermissionService.openCloseSecrity(id,secrityName,iskq);
        return msg;
    }

    @PostMapping("/system/admin/add/url")
    @ResponseBody
    public Msg addurl(@RequestParam(name = "urlName") String urlName,@RequestParam(name = "typeName") String typeName){
        Msg msg = rolePermissionService.addurl(urlName,typeName);
        return msg;
    }
}
