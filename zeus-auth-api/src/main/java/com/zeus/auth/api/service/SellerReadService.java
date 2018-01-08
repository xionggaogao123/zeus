package com.zeus.auth.api.service;


import com.zeus.auth.api.criteria.SellerCriteria;
import com.zeus.auth.api.model.Seller;
import com.zeus.common.model.Paging;
import com.zeus.common.model.Response;

/**
 * 商家 读 服务
 */
public interface SellerReadService {

    /**
     * 通过 主键 id 查找 商家
     * @param id 主键id
     * @return 商家
     */
    Response<Seller> findById(Long id);

    /**
     * 通过用户Id 查询 商家
     * @param userId 用户id
     * @return 商家信息
     */
    Response<Seller> findByUserId(Long userId);

    /**
     * 分页查询 商家
     * @param criteria 查询条件
     * @return 分页信息
     */
    Response<Paging<Seller>> paging(SellerCriteria criteria);

}
