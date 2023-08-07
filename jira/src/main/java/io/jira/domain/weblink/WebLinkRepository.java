package io.jira.domain.weblink;

import com.mongodb.client.model.Filters;
import io.jira.common.models.PaginatedEntity;
import io.jira.common.models.PaginationModel;
import io.jira.domain.weblink.filters.WebLinkFilter;
import io.jira.domain.weblink.models.WebLink;
import io.jira.mongo.MongoClientWrapper;
import io.jira.mongo.MongoCollections;
import io.jira.mongo.MongoUtils;
import io.quarkus.mongodb.reactive.ReactiveMongoCollection;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class WebLinkRepository {

    @Inject
    MongoClientWrapper mongoClientWrapper;

    public Uni<WebLink> add(WebLink webLink) {
        return MongoUtils.createEntity(getCollection(), webLink);
    }

    public Uni<PaginatedEntity<WebLink>> getAll(PaginationModel paginationModel, WebLinkFilter webLinkFilter) {
        return MongoUtils.getEntities(getCollection(), paginationModel, webLinkFilter.toBson());
    }

    public Uni<WebLink> getById(String id) {
        return MongoUtils.getEntity(getCollection(), Filters.eq(WebLink.ID_FIELD, id));
    }

    public Uni<WebLink> update(String id, WebLink webLink) {
        return MongoUtils.updateEntity(getCollection(), Filters.eq(WebLink.ID_FIELD, id), webLink);
    }

    public Uni<WebLink> delete(String id) {
        return MongoUtils.deleteEntity(getCollection(), Filters.eq(WebLink.ID_FIELD, id));
    }

    public ReactiveMongoCollection<WebLink> getCollection() {
        return mongoClientWrapper.getCollection(MongoCollections.WEBLINK, WebLink.class);
    }
}
