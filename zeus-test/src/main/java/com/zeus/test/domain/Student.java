package com.zeus.test.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author keven
 * @date 2018-01-17 上午11:06
 * @Description
 */
@Data
public class Student implements Serializable{

    private static final long serialVersionUID = -6936782752594598133L;

    private Long id;

    private String name;

    private Integer age;

    private Date createdAt;

    private Date updatedAt;



}
