package io.jira.common.models;

import java.util.List;

public class PaginatedEntity<T> {
    public List<T> data;
    public int itemCount;
    public int page;
    public int limit;
    public int pageCount;
}
