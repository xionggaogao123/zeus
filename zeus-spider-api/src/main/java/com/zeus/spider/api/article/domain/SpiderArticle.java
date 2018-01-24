package com.zeus.spider.api.article.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zeus.common.util.JsonMapper;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * @author keven
 * @date 2018-01-24 下午2:27
 * @Description
 */
@ApiModel("爬虫-文章数据实体类")
@Data
public class SpiderArticle implements Serializable{

    private static final long serialVersionUID = -2195521976501281910L;

    private static final ObjectMapper OBJECT_MAPPER = JsonMapper.nonEmptyMapper().getMapper();

    /**
     * 主键id
     */
    private Long id;

    /**
     * 文章id
     */
    private Long articleId;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 用户头像
     */
    private String userAvatar;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 文章内容
     */
    private String content;

    /**
     * 存数据库
     */
    private String imageUrl;

    /**
     * 点赞数
     */
    private Integer likesNum;

    /**
     * 分享数
     */
    private Integer sharesNum;

    /**
     * 评论数
     */
    private Integer commentsNum;

    /**
     * 评论信息
     */
    private Map<String, Object> commentInfo;

    @JsonIgnore
    private String commentInfoJson;

    /**
     * 渠道
     */
    private Integer channel;

    /**
     * 文章创建时间
     */
    private Date createTime;
}
