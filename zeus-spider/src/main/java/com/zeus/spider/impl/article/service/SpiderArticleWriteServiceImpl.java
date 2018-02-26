package com.zeus.spider.impl.article.service;

import com.google.common.base.Throwables;
import com.zeus.common.model.Response;
import com.zeus.spider.api.article.domain.SpiderArticle;
import com.zeus.spider.api.article.service.SpiderArticleWriteService;
import com.zeus.spider.impl.article.dao.SpiderArticleDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author keven
 * @date 2018-01-24 下午2:36
 * @Description
 */
@Slf4j
@Service
public class SpiderArticleWriteServiceImpl implements SpiderArticleWriteService {


    private final SpiderArticleDao spiderArticleDao;

    @Autowired
    public SpiderArticleWriteServiceImpl(SpiderArticleDao spiderArticleDao) {
        this.spiderArticleDao = spiderArticleDao;
    }

    @Override
    public Response<Long> create(SpiderArticle spiderArticle) {
        try {
            spiderArticleDao.insert(spiderArticle);
            return Response.ok(spiderArticle.getId());
        } catch (Exception e) {
            log.error("fail create spider article with article={}, cause={}", spiderArticle,
                    Throwables.getStackTraceAsString(e));
            return Response.fail("create.spider.article.fail");
        }
    }

}
