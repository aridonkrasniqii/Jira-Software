package io.jira.domain.confluencepage.filters;

import com.mongodb.client.model.Filters;
import jakarta.ws.rs.QueryParam;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;

public class ConfluencePageFilter {

    @QueryParam("any field")
    String field;


    public Bson toBson() {
        List<Bson> filter = new ArrayList<>();


        return filter.isEmpty() ? null : Filters.and(filter);
    }
}
