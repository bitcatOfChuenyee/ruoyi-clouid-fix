package com.ruoyi.demo.vo.res;

import java.util.List;

public class PageResVo<T> {
    private Long total;
    private List<T> records;

    public PageResVo(Long total, List<T> records) {
        this.total = total;
        this.records = records;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }
}
