package com.zeus.item.impl.category.service;

import com.zeus.item.api.category.domain.BackCategory;
import com.zeus.item.api.category.service.BackCategoryService;
import com.zeus.item.impl.category.dao.BackCategoryDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author keven
 * @date 2018-02-25 下午11:23
 * @Description
 */
@Service
public class BackCategoryServiceImpl implements BackCategoryService {

    @Resource
    private BackCategoryDao backCategoryDao;

    @Override
    public BackCategory findById(Long id) {
        return backCategoryDao.selectById(id);
    }

    @Override
    public List<BackCategory> findByIds(List<Long> ids) {
        return backCategoryDao.selectByIds(ids);
    }

    @Override
    public List<BackCategory> findChildrenByPid(Long pid) {
        return backCategoryDao.selectChildrenByPid(pid);
    }

    @Override
    public List<BackCategory> findAncestorsOf(Long id) {
        return backCategoryDao.selectAncestorsOf(id);
    }

    @Override
    public Long create(BackCategory backCategory) {
        return (long) backCategoryDao.insert(backCategory);
    }

    @Override
    public Boolean update(BackCategory backCategory) {
        return backCategoryDao.update(backCategory) > 0;
    }

    @Override
    public Boolean updateName(Long id, String name) {
        return backCategoryDao.updateName(id, name);
    }

    @Override
    public Boolean updateStatus(Long id, Integer status) {
        return backCategoryDao.updateStatus(id, status);
    }

    @Override
    public Boolean deleteById(Long id) {
        return backCategoryDao.delete(id) > 0;
    }
}
