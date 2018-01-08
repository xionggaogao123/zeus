package com.zeus.auth.api.criteria;

import com.zeus.common.model.PagingCriteria;
import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
@Data
public class SubSellerCriteria extends PagingCriteria{

    private Long masterUserId;

    private Integer status;

}