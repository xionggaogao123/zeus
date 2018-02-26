package com.zeus.item.api.category.service;

import com.zeus.item.api.category.domain.BackCategory;

import java.util.List;

/**
 * @author keven
 * @date 2018-02-25 下午11:08
 * @Description
 */
public interface BackCategoryService {

    /**
     * 通过 id 查询后台类目
     *
     * @param id id
     * @return 后台类目
     */
    BackCategory findById(Long id);

    /**
     * 通过 ids 查询后台类目
     *
     * @param ids ids
     * @return 后台类目列表
     */
    List<BackCategory> findByIds(List<Long> ids);

    /**
     * 根据父级类目id 查找下级类目列表
     *
     * @param pid 父级类目id 为0 表示顶级类目
     * @return 子级类目列表
     */
    List<BackCategory> findChildrenByPid(Long pid);

    /**
     * 查询从一级类目到本类目的路径上的所有后台类目列表(包括本级类目), 没有缓存
     *
     * @param id 本级类目id
     * @return 从本级类目开始的路径上的所有祖先类目列表, 不包括虚拟根节点
     */
    List<BackCategory> findAncestorsOf(Long id);

    /**
     * 创建 后台 类目
     *
     * @param backCategory 后台类目
     * @return id
     */
    Long create(BackCategory backCategory);

    /**
     * 更新 后台类目 信息
     *
     * @param backCategory 后台类目信息
     * @return true or false
     */
    Boolean update(BackCategory backCategory);

    /**
     * 修改 后台 类目 名称
     *
     * @param id   后台类目 id
     * @param name 类目名称
     * @return true or false
     */
    Boolean updateName(Long id, String name);

    /**
     * 修改 后台类目 状态；如 启用 ，禁用 等
     *
     * @param id     后台类目id
     * @param status 状态
     * @return true or false
     */
    Boolean updateStatus(Long id, Integer status);

    /**
     * 删除 后台 类目
     *
     * @param id id
     * @return true or false
     */
    Boolean deleteById(Long id);

}
