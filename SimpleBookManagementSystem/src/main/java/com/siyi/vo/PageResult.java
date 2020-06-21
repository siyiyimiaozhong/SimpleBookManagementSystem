package com.siyi.vo;

import java.util.List;

public class PageResult<T> {

    private Integer total;
    private Integer totalPage;
    private List<T> items;

    public PageResult() {
    }

    public PageResult(Integer total, List<T> items) {
        this.total = total;
        this.items = items;
    }

    public PageResult(Integer total, Integer totalPage, List<T> items) {
        this.total = total;
        this.totalPage = totalPage;
        this.items = items;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}
