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
@ApiModel("商家")
@Data
public class Seller extends BaseModel{

    private static final ObjectMapper OBJECT_MAPPER = JsonMapper.nonEmptyMapper().getMapper();

    /**
     * 商家用户id
     */
    private Long userId;

    /**
     * 商家用户名
     */
    private String userName;

    /**
     * 拥有的店铺id
     */
    private Long shopId;

    /**
     * 店铺名称
     */
    private String shopName;

    /**
     * 状态：0 未生效， 1 生效， -1 审核不通过， -2 冻结， -3 删除
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
