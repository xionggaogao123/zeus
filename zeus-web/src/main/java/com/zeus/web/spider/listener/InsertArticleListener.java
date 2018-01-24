package com.zeus.web.spider.listener;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.zeus.spider.api.article.domain.SpiderArticle;
import com.zeus.spider.api.article.service.SpiderArticleReadService;
import com.zeus.spider.api.article.service.SpiderArticleWriteService;
import com.zeus.web.spider.event.InsertArticleEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author keven
 * @date 2017-12-15 下午5:03
 * @Description
 */
@Slf4j
@Service
public class InsertArticleListener {

    private final EventBus eventBus;

    private final SpiderArticleWriteService spiderArticleWriteService;

    @Autowired
    public InsertArticleListener(SpiderArticleWriteService spiderArticleWriteService, EventBus eventBus) {
        this.spiderArticleWriteService = spiderArticleWriteService;
        this.eventBus = eventBus;
    }

    @PostConstruct
    public void register() {
        eventBus.register(this);
    }

    @Subscribe
    public void saveSpiderArticleData(InsertArticleEvent articleEvent) {
        List<SpiderArticle> articles = articleEvent.getSpiderArticles();
        for (SpiderArticle article : articles) {
            try {
                spiderArticleWriteService.create(article);
            } catch (Exception e) {
               //ignore
            }
        }
    }
}
