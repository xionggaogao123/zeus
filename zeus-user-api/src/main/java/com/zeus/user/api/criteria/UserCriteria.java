package com.zeus.user.api.criteria;

import com.zeus.common.model.PagingCriteria;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author keven
 * @date 2018-02-10 下午3:35
 * @Description
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserCriteria extends PagingCriteria{

    private static final long serialVersionUID = 5303494833480556079L;

    private String userName;

    private String mail;

    private String telPhone;



}
