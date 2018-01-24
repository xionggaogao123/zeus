package com.zeus.spider.api.article.service;

import com.zeus.common.model.Paging;
import com.zeus.common.model.Response;
import com.zeus.spider.api.article.criteria.SpiderArticleCriteria;
import com.zeus.spider.api.article.domain.SpiderArticle;

/**
 * @author keven
 * @date 2018-01-24 下午2:31
 * @Description
 */
public interface SpiderArticleReadService {

    /**
     * 根据id 查找
     * @param id id
     * @return 文章信息
     */
    Response<SpiderArticle> findById(Long id);


    /**
     * 分页查询
     * @param criteria 查询条件
     * @return 文章信息
     */
    Response<Paging<SpiderArticle>> paging(SpiderArticleCriteria criteria);
}
