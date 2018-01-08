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

import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@ApiModel("商家子账户")
@Data
public class SubSeller extends BaseModel{

    private static final ObjectMapper OBJECT_MAPPER = JsonMapper.nonEmptyMapper().getMapper();

    /**
     * 商家子账户用户id
     */
    private Long userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码（创建和更新时用到，不实际存数据库）
     */
    private String password;

    /**
     * 主账户用户 id
     */
    private Long masterUserId;

    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 角色名
     */
    private String roleName;

    /**
     * 授权状态 ： 0 未生效， 1 生效 -1 生效
     */
    private Integer status;

    @Setter(AccessLevel.NONE)
    private Map<String, String> extra;

    @Setter(AccessLevel.NONE)
    @JsonIgnore
    private String extraJson;

    @SneakyThrows
    public void setExtra(Map<String, String> extra) {
        this.extra = extra;
        if (CollectionUtils.isEmpty(extra)) {
            this.extraJson = null;
        }else {
            this.extraJson = OBJECT_MAPPER.writeValueAsString(extra);
        }
    }

    @SneakyThrows
    public void setExtraJson(String extraJson) {
        this.extraJson = extraJson;
        if (StringUtils.isEmpty(extraJson)) {
            this.extra = null;
        }else {
            this.extra = OBJECT_MAPPER.readValue(extraJson, JacksonType.MAP_OF_STRING);
        }
    }

}
