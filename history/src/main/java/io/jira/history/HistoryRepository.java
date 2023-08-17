package io.jira.history;

import com.mongodb.client.model.Filters;
import io.jira.history.common.models.PaginatedEntity;
import io.jira.history.common.models.PaginationModel;
import io.jira.history.mongo.MongoClientWrapper;
import io.jira.history.mongo.MongoCollections;
import io.jira.history.mongo.MongoUtils;
import io.quarkus.mongodb.reactive.ReactiveMongoCollection;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class HistoryRepository {

    @Inject
    MongoClientWrapper mongoClientWrapper;


    public Uni<History> add(History history) {
        return MongoUtils.createEntity(getCollection(), history);
    }

    public Uni<PaginatedEntity<History>> getAll(PaginationModel paginationModel ){
        return MongoUtils.getEntities(getCollection(), paginationModel, null);
    }

    public Uni<History> update(String id, History history) {
        return MongoUtils.updateEntity(getCollection(), Filters.eq(History.ID_FIELD, id), history);
    }

    public Uni<History> delete(String id) {
        return MongoUtils.deleteEntity(getCollection(), Filters.eq(History.ID_FIELD));
    }

    public ReactiveMongoCollection<History> getCollection() {
        return mongoClientWrapper.getCollection(MongoCollections.HISTORY_COLLECTION, History.class);
    }
}
