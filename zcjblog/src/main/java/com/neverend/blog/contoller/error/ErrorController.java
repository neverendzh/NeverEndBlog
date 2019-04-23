package com.neverend.blog.contoller.error;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author zcj
 */
@Controller
public class ErrorController {

    @GetMapping("/401")
    public String unauthorizedUrl() {
        return "error/401";
    }


}
