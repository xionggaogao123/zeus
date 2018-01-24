package com.zeus.spider.api.article.service;

import com.zeus.common.model.Response;
import com.zeus.spider.api.article.domain.SpiderArticle;

/**
 * @author keven
 * @date 2018-01-24 下午2:32
 * @Description
 */
public interface SpiderArticleWriteService {

    /**
     * 创建
     * @param spiderArticle 文章信息
     * @return true or false
     */
    Response<Long> create(SpiderArticle spiderArticle);
}
