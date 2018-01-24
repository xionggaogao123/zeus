package com.zeus.spider.api.article.criteria;

import com.zeus.common.model.PagingCriteria;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author keven
 * @date 2018-01-24 下午2:53
 * @Description
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SpiderArticleCriteria extends PagingCriteria {

    private static final long serialVersionUID = -2604647976732112746L;

    private String sinceTime;

    private List<Integer> channels;

}
