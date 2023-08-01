package io.jira.common.models;

import java.util.List;

public class PaginatedEntity<T> {
    public List<T> data;
    public int itemCount;
    public int page;
    public int limit;
    public int pageCount;


    public PaginatedEntity(List<T> data, int itemCount, int page, int limit, int pageCount) {
        this.data = data;
        this.itemCount = itemCount;
        this.page = page;
        this.limit = limit;
        this.pageCount = pageCount;
    }
}
