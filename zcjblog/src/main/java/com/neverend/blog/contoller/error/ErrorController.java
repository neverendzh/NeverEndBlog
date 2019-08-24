package com.neverend.blog.contoller.error;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author zcj
 */
@ApiIgnore
@Controller
public class ErrorController {

    @GetMapping("/401")
    public String unauthorizedUrl() {
        return "error/401";
    }


}
