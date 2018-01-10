package com.zeus.common.base;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@Data
public abstract class BaseModel implements Serializable{

    private static final long serialVersionUID = 1935079103035923219L;

    /**
     * 主键id
     */
    private Long id;

    /**
     * 创建时间
     */
    private Date createAt;

    /**
     * 更新时间
     */
    private Date updateAt;

}
