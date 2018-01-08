package com.zeus.auth.api.service;

import com.zeus.auth.api.model.SubSeller;
import com.zeus.common.model.Response;

/**
 * 商家子账户 写服务
 */
public interface SubSellerWriteService {

    /**
     * 创建商家 子账户
     * @param subSeller 子账户
     * @return id
     */
    Response<Long> createSubSeller(SubSeller subSeller);

    /**
     * 更新 商家子账户
     * @param subSeller 子账户
     * @return true or false
     */
    Response<Boolean> updateSubSeller(SubSeller subSeller);
}
