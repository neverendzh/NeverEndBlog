package com.neverend.blog.contoller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * 查看文章
 * @author zcj
 */
@Controller
@RequestMapping("/leave")
public class LeaveMessage {
    /**
     * 留言
     * @return
     */
    @GetMapping("/index")
    public String messaegIndex(){
        return "user/leacots";
    }

    /**
     * 文章详情
     * @return
     */
    @GetMapping("/details")
    public String messaegXiangQing(){
        return "user/details";
    }
}
