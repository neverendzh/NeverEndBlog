package com.neverend.blog.security;

import com.neverend.blog.entity.RolePermission;
import com.neverend.blog.service.RolePermissionService;
import org.apache.shiro.web.filter.mgt.DefaultFilterChainManager;
import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zcj
 */
public class CustomerFilterChainDefinition {
    private Logger logger = LoggerFactory.getLogger(CustomerFilterChainDefinition.class);

    @Autowired
    private RolePermissionService rolePermissionService;

    private Map<String,String> filterChainDefinitions;
    private AbstractShiroFilter shiroFilter;

    public void setFilterChainDefinitions(Map<String, String> filterChainDefinitions) {
        this.filterChainDefinitions = filterChainDefinitions;
    }

    public void setShiroFilter(AbstractShiroFilter shiroFilter) {
        this.shiroFilter = shiroFilter;
    }

    /**
     * Spring��������ʱ����
     */
    @PostConstruct
    public synchronized void init() {
        logger.info("------��ʼ��URlȨ��-----------");
        //���ԭ�е�URLȨ��
        getFilterChainManager().getFilterChains().clear();
        //�������е�URLȨ��
        load();
        logger.info("------��ʼ��URLȨ�޽���-----------");
    }

    /**
     * ���¼���URLȨ��
     */
    public synchronized void updateUrlPermission() {
        logger.info("---------ˢ��URLȨ��-----------");
        //���ԭ�е�URLȨ��
        getFilterChainManager().getFilterChains().clear();
        //�������е�URLȨ��
        load();
        logger.info("------ˢ��URLȨ�޽���-----------");
    }

    /**
     * ����URL��Ȩ�޵Ķ�Ӧ��ϵ
     */
    public synchronized void load() {
        LinkedHashMap<String,String> urlMap = new LinkedHashMap<>();
        //���ؾ�̬��Դ
        urlMap.putAll(filterChainDefinitions);

        //�����ݿ��в������е�Ȩ�޶���
        List<RolePermission> permissionList = rolePermissionService.findAllPermission();

        for(RolePermission permission : permissionList) {
            urlMap.put(permission.getUrl(),"perms["+permission.getPermissionCode()+"]");
//            System.out.println(permission.getUrl()+"--"+permission.getPermissionCode());
        }
//        urlMap.put("/**","user");

        //URL��Ȩ�޵Ĺ�ϵ���õ�shiroFilter��
        DefaultFilterChainManager defaultFilterChainManager = getFilterChainManager();
        for(Map.Entry<String,String> entry : urlMap.entrySet()) {
            defaultFilterChainManager.createChain(entry.getKey(),entry.getValue());
        }
    }


    private DefaultFilterChainManager getFilterChainManager() {
        PathMatchingFilterChainResolver pathMatchingFilterChainResolver = (PathMatchingFilterChainResolver) shiroFilter.getFilterChainResolver();
        DefaultFilterChainManager defaultFilterChainManager = (DefaultFilterChainManager) pathMatchingFilterChainResolver.getFilterChainManager();
        return defaultFilterChainManager;
    }
}
