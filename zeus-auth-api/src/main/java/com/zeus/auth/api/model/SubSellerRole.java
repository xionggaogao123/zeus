package com.zeus.auth.api.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zeus.auth.api.service.CustomRole;
import com.zeus.common.base.BaseModel;
import com.zeus.common.constants.JacksonType;
import com.zeus.common.util.JsonMapper;
import io.swagger.annotations.ApiModel;
import lombok.*;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@EqualsAndHashCode(callSuper = true)
@ApiModel("商家子账户 动态角色")
@Data
public class SubSellerRole extends BaseModel implements CustomRole{

    private static final ObjectMapper OBJECT_MAPPER = JsonMapper.nonEmptyMapper().getMapper();

    /**
     * 主账户用户id
     */
    private Long masterUserId;

    /**
     * 角色名
     */
    private String name;

    /**
     * 角色描述
     */
    private String desc;

    /**
     * 角色状态：0 未生效， 1 生效， -1 删除
     */
    private Integer status;


    /**
     * 角色对应权限树节点列表，不存数据库
     */
    @Setter(AccessLevel.NONE)
    private List<String> allow;

    /**
     * 角色对应权限数节点列表，存数据库
     */
    @Setter(AccessLevel.NONE)
    @JsonIgnore
    private String allowJson;

    @Setter(AccessLevel.NONE)
    private Map<String, String> extra;

    @Setter(AccessLevel.NONE)
    @JsonIgnore
    private String extraJson;

    @SneakyThrows
    public void setAllow(List<String> allow) {
        this.allow = allow;
        if (CollectionUtils.isEmpty(allow)) {
            this.allowJson = null;
        }else {
            this.allowJson  = OBJECT_MAPPER.writeValueAsString(allow);
        }
    }

    @SneakyThrows
    public void setAllowJson(String allowJson) {
        this.allowJson = allowJson;
        if (StringUtils.isEmpty(allowJson)) {
            this.allow = null;
        }else {
            this.allow = OBJECT_MAPPER.readValue(allowJson, new TypeReference<List<String>>(){});
        }
    }

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

    @Override
    public Boolean isActive() {
        return Objects.equals(status, 1);
    }

    @Override
    public List<String> getAllow() {
        return allow;
    }

    @Override
    public Map<String, String> getContext() {
        return Collections.emptyMap();
    }
}
