package com.zeus.common.base;


import java.io.Serializable;
import java.util.Date;

public abstract class BaseModel implements Serializable{

    private Long id;

    private Date createTime;

    private Date updateTime;

}
