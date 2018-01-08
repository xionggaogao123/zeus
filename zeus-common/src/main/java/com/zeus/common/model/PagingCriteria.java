package com.zeus.common.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zeus.common.base.BaseCriteria;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Map;

public class PagingCriteria extends BaseCriteria implements Serializable{


    @JsonIgnore
    @Setter
    @Getter
    private Integer pageNo = 1;

    @JsonIgnore
    @Setter
    @Getter
    private Integer pageSize = 20;

    @JsonIgnore
    private Boolean hasNext = true;


    public PagingCriteria() {

    }

    @JsonIgnore
    public Boolean hasNext() {
        return this.hasNext;
    }

    public void nextPage() {
        if (this.pageNo == null) {
            this.pageNo = 1;
        }

        this.pageNo = this.pageNo + 1;
    }

    public Integer getLimit() {
        PageInfo pageInfo = new PageInfo(this.pageNo, this.pageSize);
        return pageInfo.getLimit();
    }

    public Integer getOffset() {
        PageInfo pageInfo = new PageInfo(this.pageNo, this.pageSize);
        return pageInfo.getOffset();
    }

    public Map<String, Object> toMap() {
        this.formatDate();
        return super.toMap();
    }

    protected void formatDate() {

    }

}
