package com.neverend.blog.contoller.AdminUserPublic;

import com.neverend.blog.moudel.Msg;
import com.neverend.blog.service.AccountService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
public class RegisteredAccount {

    @Autowired
    private AccountService accountService;

    /**
     * QQ登陆
     *
     * @return
     */
    @PostMapping("qq/login")
    @ApiIgnore
    public String QQRegisteredAccount() {

        return "admin/login";
    }


    /**
     * @param userName      用户名称
     * @param accountNumber 账号
     * @param password      密码
     * @param isEncryption  密码前端是否加密
     * @return
     */
    @ApiOperation(value = "注册账号", httpMethod = "POST",
            notes = "普通用户账号注册", protocols = "http")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名称",
                    required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "accountNumber", value = "账号",
                    required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "password", value = "密码",
                    required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "isEncryption", value = "前端是否已经使用MD5 32位加密，true已加密，false未加密",
                    required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "email", value = "邮箱",
                    required = true, dataType = "String", paramType = "query")})
    @PostMapping("/registered/account")
    public Msg RegisteredAccountjson(@RequestParam(name = "userName") String userName,
                                 @RequestParam(name = "accountNumber") String accountNumber,
                                 @RequestParam(name = "password") String password,
                                 @RequestParam(name = "isEncryption") String isEncryption,
                                 @RequestParam(name = "email") String email, Device device) {
        Msg msg = accountService.registeredAccount(userName, accountNumber, password, isEncryption, email);

        return msg;
    }
}
