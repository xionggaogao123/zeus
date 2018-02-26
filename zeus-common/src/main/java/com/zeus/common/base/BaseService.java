package com.zeus.common.base;

import com.zeus.common.model.Paging;
import com.zeus.common.model.PagingCriteria;

import java.util.List;

/**
 * @author keven
 * @date 2018-02-10 下午3:59
 * @Description
 */
public abstract class BaseService<T> {

    protected abstract BaseMyBatisDao<T> getEntityDao();

    public T findById(Long id) {
        return getEntityDao().selectById(id);
    }

    public List<T> findByIds(List<Long> ids) {
        return getEntityDao().selectByIds(ids);
    }

    public Paging<T> paging(PagingCriteria criteria) {
        return getEntityDao().selectPaging(criteria);
    }

    public Long create(T entity) {
        return (long) getEntityDao().insert(entity);
    }

    public Boolean update(T entity) {
        return getEntityDao().update(entity) > 0;
    }

    public Boolean deleteById(Long id) {
        return getEntityDao().delete(id) > 0;
    }
}
