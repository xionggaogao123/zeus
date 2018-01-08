package com.zeus.auth.api.criteria;


import com.zeus.common.model.PagingCriteria;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class OperatorCriteria extends PagingCriteria{

    /**
     * 运营角色id
     */
    private Long roleId;

    /**
     * 运营用户状态
     */
    private Integer status;

}
