package com.neverend.blog;

import com.neverend.blog.util.email.MailService;
import com.neverend.blog.util.email.MailServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Autowired
    MailService mailService;
    @Test
    public void contextLoads() {
        mailService.sendSimpleMail();
    }

}
