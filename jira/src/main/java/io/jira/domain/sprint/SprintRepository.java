package io.jira.domain.sprint;


import com.mongodb.client.model.Filters;
import io.jira.common.models.PaginatedEntity;
import io.jira.common.models.PaginationModel;
import io.jira.domain.sprint.filters.SprintFilter;
import io.jira.domain.sprint.models.Sprint;
import io.jira.mongo.MongoClientWrapper;
import io.jira.mongo.MongoCollections;
import io.jira.mongo.MongoUtils;
import io.quarkus.mongodb.reactive.ReactiveMongoCollection;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import static com.mongodb.client.model.Filters.eq;

@ApplicationScoped
public class SprintRepository {

    @Inject
    MongoClientWrapper mongoClientWrapper;

    public Uni<Sprint> add(Sprint sprint) {
        return MongoUtils.createEntity(getCollection(), sprint);
    }

    public Uni<PaginatedEntity<Sprint>> getAll(PaginationModel paginationModel, SprintFilter sprintFilter) {
        return MongoUtils.getEntities(getCollection(), paginationModel, sprintFilter.toBson());
    }

    public Uni<Sprint> getById(String id) {
        return MongoUtils.getEntity(getCollection(), Filters.eq(Sprint.ID_FIELD, id));
    }

    public Uni<Sprint> update(String id, Sprint sprint) {
        return MongoUtils.updateEntity(getCollection(), Filters.eq(Sprint.ID_FIELD, id), sprint);
    }

    public Uni<Sprint> delete(String id) {
        return MongoUtils.deleteEntity(getCollection(), Filters.eq(Sprint.ID_FIELD, id));
    }


    private ReactiveMongoCollection<Sprint> getCollection() {
        return mongoClientWrapper.getCollection(MongoCollections.SPRINT, Sprint.class);
    }
}
