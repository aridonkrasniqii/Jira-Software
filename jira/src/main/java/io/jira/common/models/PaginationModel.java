package io.jira.common.models;

import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import jakarta.ws.rs.QueryParam;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;


public class PaginationModel {
    public static final int LIMIT = 50;
    public static final int PAGE_SIZE = 10;


    @QueryParam("page")
    private int page;
    @QueryParam("limit")
    private int limit;

    @QueryParam("asc")
    private String asc;

    @QueryParam("desc")
    private String desc;

    @QueryParam("q")
    private String q;

    private List<String> searchFields;

    public void setSearchFields(String... searchFields) {
        this.searchFields.addAll(List.of(searchFields));
    }

    public Bson getSearch() {
        List<Bson> search = new ArrayList<>();

        searchFields.forEach(field -> {
            Bson regexFilter = Filters.regex(field, getSearchValue(), "i");
            search.add(Aggregates.match(regexFilter));
        });

        return search.isEmpty() ? null : Filters.and(search);
    }

    public int getSkip() {
        return (getPage() - 1) * PAGE_SIZE;
    }

    public String getSearchValue() {
        return q;
    }

    public int getPage() {
        if (page == 0) {
            return page + 1;
        }
        return page;
    }

    public int getLimit() {
        if (limit == 0) {
            return LIMIT;
        }
        return limit;
    }

    public String getAsc() {
        return asc;
    }

    public String getDesc() {
        return desc;
    }

}