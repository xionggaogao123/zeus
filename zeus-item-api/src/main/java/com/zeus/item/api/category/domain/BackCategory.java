package com.zeus.item.api.category.domain;

import com.zeus.common.base.BaseDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author keven
 * @date 2018-02-25 下午10:49
 * @Description 后台类目
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BackCategory extends BaseDomain{

    private static final long serialVersionUID = 5966301575751683615L;

    /**
     * 上级类目id , 0 表示顶级类目
     */
    private Long pid;

    /**
     * 类目 名称
     */
    private String name;


    /**
     * 类目层级 , 从 1 开始
     */
    private Integer level;


    /**
     * 后台类目 状态
     */
    private Integer status;


    /**
     * 表示 是否有 孩子类目
     */
    private Boolean hasChildren;


    /**
     * 标识是否SPU绑定
     */
    private Boolean hasSpu;

    /**
     * 外部后台类目 id
     */
    private String outerId;

}
