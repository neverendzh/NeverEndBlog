package com.neverend.blog.service.impl;

import com.neverend.blog.entity.Roles;
import com.neverend.blog.entity.RolesExample;
import com.neverend.blog.mapper.RolesMapper;
import com.neverend.blog.moudel.Code;
import com.neverend.blog.moudel.Msg;
import com.neverend.blog.service.RoleService;
import com.neverend.blog.util.email.GetMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("ALL")
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RolesMapper rolesMapper;
    /**
     * 获取角色
     *
     * @return
     */
    @Override
    public Msg getRoles() {
        RolesExample rolesExample = new RolesExample();
        RolesExample.Criteria criteria = rolesExample.createCriteria();
        List<Roles> roles = rolesMapper.selectByExample(rolesExample);
        Msg msg = GetMsg.getMsg();
        msg.setCode(Code.sucess);
        msg.setMsg(Code.sucessMsg);
        msg.setData(roles);
        msg.setCount(Integer.toString(roles.size()));
        return msg;
    }
}
