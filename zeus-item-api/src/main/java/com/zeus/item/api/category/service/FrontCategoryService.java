package com.zeus.item.api.category.service;

import com.zeus.item.api.category.domain.FrontCategory;

import java.util.List;

/**
 * @author keven
 * @date 2018-02-25 下午11:29
 * @Description
 */
public interface FrontCategoryService {

    /**
     * 根据 id 查找 前台类目
     *
     * @param id id
     * @return 前台类目
     */
    FrontCategory findById(Long id);

    /**
     * 根据 ids 查找 前台类目
     *
     * @param ids ids
     * @return 前台类目列表
     */
    List<FrontCategory> findByIds(List<Long> ids);

    /**
     * 根据父级类目查找子级类目
     *
     * @param pid 父级类目
     * @return 子级类目列表
     */
    List<FrontCategory> findChildrenByPid(Long pid);

}
