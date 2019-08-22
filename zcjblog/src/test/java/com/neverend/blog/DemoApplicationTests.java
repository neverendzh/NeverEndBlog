package com.neverend.blog;

import com.neverend.blog.dao.ArticleSuperArticleIdDao;
import com.neverend.blog.entity.ArticleSuperArticleId;
import com.neverend.blog.mapper.ArticleSuperArticleIdMapper;
import com.neverend.blog.util.email.MailService;
import com.neverend.blog.util.email.MailServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Autowired
    MailService mailService  ;
    @Autowired
    ArticleSuperArticleIdDao articleSuperArticleIdDao;
    @Autowired
    ArticleSuperArticleIdMapper articleSuperArticleIdMapper;
    @Test
    public void contextLoads() {
        List<ArticleSuperArticleId> articleSuperArticleIds = new ArrayList<>();
        ArticleSuperArticleId articleSuperArticleId = new ArticleSuperArticleId();
        articleSuperArticleId.setId(UUID.randomUUID()+"");
        articleSuperArticleId.setArticleId("1");
        articleSuperArticleId.setSuperArticleId("2");
        ArticleSuperArticleId articleSuperArticleId1 = new ArticleSuperArticleId();
        articleSuperArticleId1.setId(UUID.randomUUID()+"");
        articleSuperArticleId1.setArticleId("1");
        articleSuperArticleId1.setSuperArticleId("2");
        articleSuperArticleIds.add(articleSuperArticleId);
        articleSuperArticleIds.add(articleSuperArticleId1);
        int a = articleSuperArticleIdDao.save(articleSuperArticleIds);
        System.out.println(a+"22");
    }
    @Test
    public void contextLoadss() {

        ArticleSuperArticleId articleSuperArticleId = new ArticleSuperArticleId();
//        articleSuperArticleId.setId("1");
        articleSuperArticleId.setArticleId("1");
        articleSuperArticleId.setSuperArticleId("2");

        int a = articleSuperArticleIdMapper.insert(articleSuperArticleId);
        System.out.println(a+"22");
    }
}
