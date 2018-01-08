package com.zeus.auth.api.service;

import com.zeus.auth.api.model.Seller;
import com.zeus.common.model.Response;

/**
 * 商家 写 服务
 */
public interface SellerWriteService {

    /**
     * 创建 商家信息
     * @param seller 商家信息
     * @return id
     */
    Response<Long> create(Seller seller);

    /**
     * 更新 商家 信息
     * @param seller 商家信息
     * @return true or false
     */
    Response<Boolean> update(Seller seller);
}
