package com.zeus.user.api.domain;

import com.zeus.common.base.BaseDomain;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author keven
 * @date 2018-02-10 下午3:21
 * @Description
 */

@ApiModel("用户实体类")
@Data
@EqualsAndHashCode(callSuper = true)
public class User extends BaseDomain{

    private static final long serialVersionUID = -5854818184395949154L;

    /**
     * 用户名
     */
    private String username;

    /**
     * 手机号码
     */
    private String telPhone;

    /**
     * 邮箱
     */
    private String mail;

    /**
     * 用户类型
     */
    private Integer type;


    /**
     * 状态
     */
    private Integer status;


    /**
     * 头像url
     */
    private String avatarUrl;


    /**
     * 登录密码
     */
    private String password;


    /**
     * 性别
     */
    private String gender;


    /**
     * 出生日期
     */
    private Date birthday;


    /**
     * 地址
     */
    private String address;



}
