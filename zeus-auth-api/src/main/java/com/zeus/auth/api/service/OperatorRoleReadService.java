package com.zeus.auth.api.service;


import com.zeus.auth.api.criteria.OperatorRoleCriteria;
import com.zeus.auth.api.model.OperatorRole;
import com.zeus.common.model.Paging;
import com.zeus.common.model.Response;

import java.util.List;

/**
 * 运营角色读服务
 */
public interface OperatorRoleReadService {

    /**
     * 通过 id 查询
     *
     * @param id id
     * @return 运营角色
     */
    Response<OperatorRole> findById(Long id);

    /**
     * 通过 ids 批量查询 运营角色
     *
     * @param ids ids
     * @return 运营角色列表
     */
    Response<List<OperatorRole>> findByIds(List<Long> ids);

    /**
     * 通过角色 状态 查询
     *
     * @param status 状态
     * @return 运营角色
     */
    Response<List<OperatorRole>> findByStatus(Integer status);

    /**
     * 分页查询 运营角色
     *
     * @param criteria 查询条件
     * @return 运营角色列表
     */
    Response<Paging<OperatorRole>> paging(OperatorRoleCriteria criteria);

}
