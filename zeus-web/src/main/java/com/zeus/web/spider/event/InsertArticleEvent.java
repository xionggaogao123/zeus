package com.zeus.web.spider.event;

import com.zeus.spider.api.article.domain.SpiderArticle;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author keven
 * @date 2017-12-15 下午5:01
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InsertArticleEvent implements Serializable{

    private static final long serialVersionUID = -3155599008496974442L;

    List<SpiderArticle> spiderArticles;

}
