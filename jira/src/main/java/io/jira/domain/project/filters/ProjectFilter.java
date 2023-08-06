package io.jira.domain.project.filters;

import com.mongodb.client.model.Filters;
import jakarta.ws.rs.QueryParam;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;

public class ProjectFilter {
    @QueryParam("name")
    String name;

    public Bson toBson() {
        List<Bson> pipeline = new ArrayList<>();

        return pipeline.isEmpty() ? null : Filters.and(pipeline);
    }
}
