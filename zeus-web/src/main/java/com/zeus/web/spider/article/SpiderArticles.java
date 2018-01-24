package com.zeus.web.spider.article;

import com.zeus.common.exception.JsonResponseException;
import com.zeus.common.model.Paging;
import com.zeus.common.model.Response;
import com.zeus.spider.api.article.criteria.SpiderArticleCriteria;
import com.zeus.spider.api.article.domain.SpiderArticle;
import com.zeus.spider.api.article.service.SpiderArticleReadService;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author keven
 * @date 2017-12-15 上午9:43
 * @Description
 */
@Slf4j
@RestController
@RequestMapping("/spider/article")
public class SpiderArticles {

    private static final DateTimeFormatter DATE_TIME_FORMAT = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");

    private final SpiderArticleReadService spiderArticleReadService;

    @Autowired
    public SpiderArticles(SpiderArticleReadService spiderArticleReadService) {
        this.spiderArticleReadService = spiderArticleReadService;
    }

    /**
     * 分页 显示 数据，只显示有文字的，channel为1，3，
     *
     * @return 分页数据
     */
    @GetMapping("paging")
    public Paging<SpiderArticle> paging(SpiderArticleCriteria criteria, HttpServletRequest request, HttpServletResponse response) {
        //记录cookie
        recordCookie(criteria, request, response);

        Response<Paging<SpiderArticle>> pagingResponse = spiderArticleReadService.paging(criteria);
        if (!pagingResponse.isSuccess()) {
            log.error("fail paging spiderArticle with criteria={}, cause={}", criteria, pagingResponse.getError());
            throw new JsonResponseException(pagingResponse.getError());
        }
        return pagingResponse.getResult();
    }

    private void recordCookie(SpiderArticleCriteria criteria, HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        String cookiePageNoName = null;
        Integer cookiePageNoValue = null;
        if (cookies == null) {
            Cookie cookie = new Cookie("pageNo", String.valueOf(criteria.getPageNo()));
            cookie.setMaxAge(3600 * 24 * 3);
            response.addCookie(cookie);
        } else {
            for (Cookie c : cookies) {
                String cookieName = c.getName();
                if ("pageNo".equals(cookieName)) {
                    cookiePageNoName = c.getName();
                    cookiePageNoValue = Integer.valueOf(c.getValue());
                }
            }
            Cookie cookie = new Cookie("pageNo", String.valueOf(criteria.getPageNo()));

            if (cookiePageNoName == null) {
                cookie.setMaxAge(3600 * 24 * 3);
                response.addCookie(cookie);
            } else {
                Integer pageNo = cookiePageNoValue + 1;
                criteria.setPageNo(pageNo);
                cookie.setValue(String.valueOf(pageNo));
                response.addCookie(cookie);
            }
        }
    }

    /**
     * 提供一个接口给 另外一个模块调用，完成时间的迁移, 主掉方 是一个job, 这里只是暴露出一个接口
     */
    @GetMapping("list-since")
    public List<SpiderArticle> getSpiderArticles(@RequestParam Integer pageNo, Integer pageSize) {
        SpiderArticleCriteria criteria = new SpiderArticleCriteria();
        criteria.setPageNo(pageNo);
        criteria.setPageSize(pageSize);
        criteria.setSinceTime(DATE_TIME_FORMAT.print(DateTime.now().withTimeAtStartOfDay().minusDays(1)));
        return spiderArticleReadService.paging(criteria).getResult().getData();
    }

}
