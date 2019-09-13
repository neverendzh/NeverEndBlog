package com.neverend.blog.service;

import com.neverend.blog.moudel.Msg;
import org.springframework.stereotype.Service;

public interface RoleService {
    /**
     * 获取角色
     * @return
     */
   Msg getRoles();
}
