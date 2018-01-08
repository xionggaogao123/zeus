package com.zeus.auth.api.service;


import java.util.List;
import java.util.Map;

public interface CustomRole {


    /**
     * 角色id
     */
    Long getId();

    /**
     * 是否生效
     */
    Boolean isActive();

    /**
     * 选中的权限树上的节点列表
     */
    List<String> getAllow();

    /**
     * 其他环境值
     */
    Map<String, String> getContext();

}
