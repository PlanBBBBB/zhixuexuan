package com.zhixue.search.dto;

import com.zhixue.base.model.PageResult;
import lombok.ToString;

import java.util.List;

@ToString
public class SearchPageResultDto<T> extends PageResult<T> {

    /**
     * 大分类列表
     */
    List<String> mtList;

    /**
     * 小分类列表
     */
    List<String> stList;


    public SearchPageResultDto(List<T> items, long counts, long page, long pageSize) {
        super(items, counts, page, pageSize);
    }

    public List<String> getMtList() {
        return mtList;
    }

    public void setMtList(List<String> mtList) {
        this.mtList = mtList;
    }

    public List<String> getStList() {
        return stList;
    }

    public void setStList(List<String> stList) {
        this.stList = stList;
    }
}
