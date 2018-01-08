package com.zeus.auth.api.service;

import com.zeus.auth.api.model.SubSellerRole;
import com.zeus.common.model.Response;

import java.util.List;

/**
 * 商家 自定义 角色 读服务
 */
public interface SubSellerRoleReadService {

    /**
     * 通过id 查找
     * @param id id
     * @return 自定义角色
     */
    Response<SubSellerRole> findById(Long id);

    /**
     * 通过 ids 查询
     * @param ids ids
     * @return 列表
     */
    Response<List<SubSellerRole>> findByIds(List<Long> ids);


    /**
     *
     * @param masterUserId
     * @param status
     * @return
     */
    Response<List<SubSellerRole>> findByMasterUserIdAndStatus(Long masterUserId, Integer status);


}
