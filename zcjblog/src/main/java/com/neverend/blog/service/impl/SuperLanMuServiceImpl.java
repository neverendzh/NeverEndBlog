package com.neverend.blog.service.impl;

import com.neverend.blog.dao.SuperLanMuDao;
import com.neverend.blog.entity.Account;
import com.neverend.blog.mapper.SuperLanMuMapper;
import com.neverend.blog.moudel.LanMuUi;
import com.neverend.blog.service.SuperLanMuService;
import com.neverend.blog.util.email.redis.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author zcj
 */
@Service
public class SuperLanMuServiceImpl implements SuperLanMuService {
    private Logger logger = LoggerFactory.getLogger(SuperLanMuServiceImpl.class);
    private String lanMukeytb = "lanmukeyTb";
    private String lanMukeywb = "lanMukeywb";
    @Autowired
    private SuperLanMuDao superLanMuDao;
    @Autowired
    private RedisUtil redisUtil;

    /**
     * 获取首页栏目信息
     *
     * @param LanMuName 例如传入‘首页头部’
     * @return
     */
    @Override
    public List<LanMuUi> getLanMus(Account account, String LanMuName, String state) {
        if (account != null && account.getId() != null && !"".equals(account.getId())) {
            List<Object> objects = redisUtil.lGet(lanMukeytb+account.getBeiYongEr(), 0L, -1);
            List<LanMuUi> lanMuUis = zhua(objects);
            if (lanMuUis != null) {
                return lanMuUis;
            } else {
                List<LanMuUi> lanMustb = superLanMuDao.getLanMus(account.getId(), LanMuName, state);
                boolean b = redisUtil.lSet(lanMukeytb+account.getBeiYongEr(), lanMustb);
                if (!b) {
                    logger.error("首页头部加入缓存失败");
                }
                return lanMustb;
            }
        } else {
            List<Object> objects = redisUtil.lGet(lanMukeywb, 0L, -1);
            List<LanMuUi> lanMuUis = zhua(objects);
            if (lanMuUis != null) {
                return lanMuUis;
            } else {
                List<LanMuUi> lanMus = superLanMuDao.getLanMus("1", LanMuName, state);
                boolean b = redisUtil.lSet(lanMukeywb, lanMus);
                if (!b) {
                    logger.error("首页尾部加入缓存失败");
                }
                return lanMus;

            }
        }
    }

    /**
     * 类型转换
     *
     * @param objects
     * @return
     */
    private List<LanMuUi> zhua(List<Object> objects) {
        if (objects != null &&objects.size() > 0) {
            List<LanMuUi> lanMuUis = (List<LanMuUi>) objects.get(0);
            return lanMuUis;
        }
        return null;
    }


}
