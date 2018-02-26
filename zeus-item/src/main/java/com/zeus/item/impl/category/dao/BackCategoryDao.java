package com.zeus.item.impl.category.dao;

import com.google.common.collect.ImmutableMap;
import com.zeus.common.base.BaseMyBatisDao;
import com.zeus.item.api.category.domain.BackCategory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author keven
 * @date 2018-02-25 下午11:21
 * @Description
 */
@Repository
public class BackCategoryDao extends BaseMyBatisDao<BackCategory> {


    public List<BackCategory> selectChildrenByPid(Long pid) {
        return sqlSession.selectList(sqlId("selectChildrenByPid"), pid);
    }

    public List<BackCategory> selectAncestorsOf(Long id) {
        return sqlSession.selectList(sqlId("selectAncestorsOf"), id);
    }

    public Boolean updateName(Long id, String name) {
        return sqlSession.update(sqlId("updateName"),
                ImmutableMap.of("id", id, "name", name)) > 0;
    }

    public Boolean updateStatus(Long id, Integer status) {
        return sqlSession.update(sqlId("updateStatus"),
                ImmutableMap.of("id", id, "status", status)) > 0;
    }


}
