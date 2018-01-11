package com.zeus.auth.api.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zeus.common.base.BaseModel;
import com.zeus.common.constants.JacksonType;
import com.zeus.common.util.JsonMapper;
import io.swagger.annotations.ApiModel;
import lombok.*;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@ApiModel("用户运营表")
@Data
public class Operator extends BaseModel {

    private static final ObjectMapper OBJECT_MAPPER = JsonMapper.nonEmptyMapper().getMapper();

    /**
     * 运营用户id
     */
    private Long userId;

    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 角色名
     */
    private String roleName;

    /**
     * 状态 : 1 生效， -1 删除
     */
    private Integer status;

    /**
     * 扩展信息，不存数据库
     */
    @Setter(AccessLevel.NONE)
    private Map<String, String> extra;

    /**
     * 扩展信息 json, 存数据库
     */
    @Setter(AccessLevel.NONE)
    @JsonIgnore
    private String extraJson;


    @SneakyThrows
    public void setExtra(Map<String, String> extra) {
        this.extra = extra;
        if (CollectionUtils.isEmpty(extra)) {
            this.extraJson = null;
        } else {
            this.extraJson = OBJECT_MAPPER.writeValueAsString(extra);
        }
    }


    @SneakyThrows
    public void setExtraJson(String extraJson) {
        this.extraJson = extraJson;
        if (StringUtils.isEmpty(extraJson)) {
            this.extra = Collections.emptyMap();
        } else {
            this.extra = OBJECT_MAPPER.readValue(extraJson, JacksonType.MAP_OF_STRING);
        }
    }




}
