package com.neverend.blog.contoller.admin.messagecrm;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import springfox.documentation.annotations.ApiIgnore;

@Controller
@ApiIgnore
public class msgcrm {
    @GetMapping("/system/admin/msg/crm")
    public String urledit(){
        return "admin/messagecrm/message";
    }
}
