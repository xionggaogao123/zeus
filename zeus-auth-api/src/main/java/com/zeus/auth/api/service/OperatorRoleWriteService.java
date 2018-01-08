package com.zeus.auth.api.service;

import com.zeus.auth.api.model.OperatorRole;
import com.zeus.common.model.Response;

/**
 * 运营角色 写服务
 */
public interface OperatorRoleWriteService {

    /**
     * 创建 运营 角色
     * @param operatorRole 运营角色
     * @return id
     */
    Response<Long> create(OperatorRole operatorRole);


    /**
     * 更新 运营 角色
     * @param operatorRole 运营角色
     * @return true of false
     */
    Response<Boolean> update(OperatorRole operatorRole);

}
