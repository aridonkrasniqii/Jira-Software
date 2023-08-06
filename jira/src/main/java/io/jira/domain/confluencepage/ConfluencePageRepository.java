package io.jira.domain.confluencepage;

import com.mongodb.client.model.Filters;
import io.jira.common.models.PaginatedEntity;
import io.jira.common.models.PaginationModel;
import io.jira.domain.confluencepage.filters.ConfluencePageFilter;
import io.jira.domain.confluencepage.models.ConfluencePage;
import io.jira.mongo.MongoClientWrapper;
import io.jira.mongo.MongoCollections;
import io.jira.mongo.MongoUtils;
import io.quarkus.mongodb.reactive.ReactiveMongoCollection;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ConfluencePageRepository {

    @Inject
    MongoClientWrapper mongoClientWrapper;

    public Uni<ConfluencePage> add(ConfluencePage confluencePage) {
        return MongoUtils.createEntity(getCollection(), confluencePage);
    }

    public Uni<PaginatedEntity<ConfluencePage>> getAll(PaginationModel paginationModel, ConfluencePageFilter confluencePageFilter) {
        return MongoUtils.getEntities(getCollection(), paginationModel, confluencePageFilter.toBson());
    }

    public Uni<ConfluencePage> getById(String id) {
        return MongoUtils.getEntity(getCollection(), Filters.eq(ConfluencePage.ID_FIELD, id));
    }

    public Uni<ConfluencePage> update(String id, ConfluencePage confluencePage) {
        return MongoUtils.updateEntity(getCollection(), Filters.eq(ConfluencePage.ID_FIELD, id), confluencePage);
    }

    public Uni<ConfluencePage> delete(String id) {
        return MongoUtils.deleteEntity(getCollection(), Filters.eq(ConfluencePage.ID_FIELD, id));
    }

    public ReactiveMongoCollection<ConfluencePage> getCollection() {
        return mongoClientWrapper.getCollection(MongoCollections.CONFLUENCE_PAGE, ConfluencePage.class);
    }
}
