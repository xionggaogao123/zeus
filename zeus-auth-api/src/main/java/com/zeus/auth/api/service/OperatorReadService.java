package com.zeus.auth.api.service;

import com.zeus.auth.api.model.Operator;
import com.zeus.common.model.Paging;
import com.zeus.common.model.Response;

/**
 * 运营信息 读 服务
 */
public interface OperatorReadService {

    /**
     * 通过 用户 id 查询运营信息
     * @param userId 用户id
     * @return 运营信息
     */
    Response<Operator> findByUserId(Long userId);


    Response<Paging<Operator>> paging();

}
