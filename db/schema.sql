
### spider 模块  start ###
CREATE TABLE `spider_article`(
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `article_id` bigint(20) DEFAULT NULL COMMENT'文章id',
  `user_name` VARCHAR(64) DEFAULT NULL  COMMENT '用户名称',
  `user_avatar` VARCHAR(1024) DEFAULT NULL COMMENT '用户头像',
  `title` VARCHAR(1024) DEFAULT NULL COMMENT '标题',
  `content` VARCHAR(2048) DEFAULT NULL  COMMENT '内容',
  `image_url` VARCHAR(128) DEFAULT NULL  COMMENT '图片',
  `likes_num` INT(20) DEFAULT 0 COMMENT '点赞数',
  `shares_num` INT(20) DEFAULT 0 COMMENT '分享数',
  `comments_num` INT(20) DEFAULT 0 COMMENT '评论数',
  `comment_info_json` VARCHAR(4048) DEFAULT NULL  COMMENT '评论信息',
  `channel` INT(11) DEFAULT NULL COMMENT '数据来源渠道',
  `create_time` datetime DEFAULT NULL COMMENT '文章创建时间',
  PRIMARY KEY (`id`),
  KEY `idx_article_id` (`article_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='爬数据-文章信息表';

# -  添加 联合 唯一 性
ALTER TABLE spider_article ADD UNIQUE KEY(article_id, channel);

# - 设置 content 字符集 为 utf8md4
ALTER TABLE spider_article modify content VARCHAR(2048) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci ;
ALTER TABLE spider_article modify title VARCHAR(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci ;
ALTER TABLE spider_article modify user_name VARCHAR(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

### spider 模块  end ###