package com.zeus.spider.impl.article.service;

import com.google.common.base.Throwables;
import com.zeus.common.model.Paging;
import com.zeus.common.model.Response;
import com.zeus.spider.api.article.criteria.SpiderArticleCriteria;
import com.zeus.spider.api.article.domain.SpiderArticle;
import com.zeus.spider.api.article.service.SpiderArticleReadService;
import com.zeus.spider.impl.article.dao.SpiderArticleDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author keven
 * @date 2018-01-24 下午2:33
 * @Description
 */
@Slf4j
@Service
public class SpiderArticleReadServiceImpl implements SpiderArticleReadService {

    private final SpiderArticleDao spiderArticleDao;

    @Autowired
    public SpiderArticleReadServiceImpl(SpiderArticleDao spiderArticleDao) {
        this.spiderArticleDao = spiderArticleDao;
    }

    @Override
    public Response<SpiderArticle> findById(Long id) {
        try {
            return Response.ok(spiderArticleDao.findById(id));
        } catch (Exception e) {
            log.error("fail find spider article with id={}, cause={}", id, Throwables.getStackTraceAsString(e));
            return Response.fail("find.spider.article.fail");
        }
    }

    @Override
    public Response<Paging<SpiderArticle>> paging(SpiderArticleCriteria criteria) {
        try {
            return Response.ok(spiderArticleDao.paging(criteria.toMap()));
        } catch (Exception e) {
            log.error("fail paging spider article with criteria={}, cause={}", criteria,
                    Throwables.getStackTraceAsString(e));
            return Response.fail("paging.spider.article.fail");
        }
    }
}
