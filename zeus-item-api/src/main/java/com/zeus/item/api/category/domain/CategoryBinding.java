package com.zeus.item.api.category.domain;

import com.zeus.common.base.BaseDomain;

/**
 * @author keven
 * @date 2018-02-25 下午11:07
 * @Description 前台类目-后台类目 绑定 关联表
 */
public class CategoryBinding extends BaseDomain{

    private static final long serialVersionUID = -4261449058030638152L;


    /**
     * 前台叶子类目ID
     */
    private Long frontCategoryId;


    /**
     * 后台叶子类目ID
     */
    private Long backCategoryId;

}
