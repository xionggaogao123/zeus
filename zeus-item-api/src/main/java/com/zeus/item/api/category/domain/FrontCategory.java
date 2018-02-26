package com.zeus.item.api.category.domain;

import com.zeus.common.base.BaseDomain;

/**
 * @author keven
 * @date 2018-02-25 下午11:03
 * @Description 前台类目
 */
public class FrontCategory extends BaseDomain{

    private static final long serialVersionUID = -1518763443883418733L;


    /**
     * 上级类目ID, 0 表示顶级类目
     */
    private Long pid;


    /**
     * 前台类目 名称
     */
    private String name;


    /**
     * 类目层级 从1 开始
     */
    private Integer level;


    /**
     * 标识是否有孩子 类目
     */
    private Boolean hasChildren;


    /**
     * 前台类目 logo
     */
    private String logo;


    /**
     * 外部前台类目 id
     */
    private String outerId;



}
