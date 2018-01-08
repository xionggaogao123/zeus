package com.zeus.auth.api.service;


import com.zeus.auth.api.model.Operator;
import com.zeus.common.model.Response;

public interface OperatorWriteService {

    /**
     * 创建 运营
     * @param operator 运营信息
     * @return 运营用户id
     */
    Response<Long> create(Operator operator);

    /**
     * 更新 运营信息
     * @param operator 运营信息
     * @return true or false
     */
    Response<Boolean> update(Operator operator);
}
