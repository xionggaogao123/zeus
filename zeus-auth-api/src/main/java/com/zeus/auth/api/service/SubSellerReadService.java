package com.zeus.auth.api.service;


import com.zeus.auth.api.criteria.SubSellerCriteria;
import com.zeus.auth.api.model.SubSeller;
import com.zeus.common.model.Paging;
import com.zeus.common.model.Response;

/**
 * 商家子 账户 读 服务
 */
public interface SubSellerReadService {

    /**
     * 通过商家子 账户 查询
     * @param id id
     * @return 子账户 信息
     */
    Response<SubSeller> findById(Long id);

    /**
     * 通过子账户id 查询 子账户 信息
     * @param userId userId
     * @return
     */
    Response<SubSeller> findByUserId(Long userId);

    /**
     * 分页查询 子 账户信息
     * @param criteria 查询条件
     * @return 子账户分页信息
     */
    Response<Paging<SubSeller>> paging(SubSellerCriteria criteria);
}
