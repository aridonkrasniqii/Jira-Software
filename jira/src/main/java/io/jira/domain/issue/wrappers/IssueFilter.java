package io.jira.domain.issue.wrappers;

import com.mongodb.client.model.Filters;
import jakarta.ws.rs.QueryParam;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;

public class IssueFilter {

    @QueryParam("summary")
    String summary;



    public Bson toBson() {
        List<Bson> filter = new ArrayList<>();


        return filter.isEmpty() ? null : Filters.and(filter);
    }
}
