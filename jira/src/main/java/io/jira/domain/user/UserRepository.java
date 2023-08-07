package io.jira.domain.user;

import com.mongodb.client.model.Filters;
import io.jira.common.models.PaginatedEntity;
import io.jira.common.models.PaginationModel;
import io.jira.domain.user.filters.UserFilter;
import io.jira.domain.user.models.User;
import io.jira.mongo.MongoClientWrapper;
import io.jira.mongo.MongoCollections;
import io.jira.mongo.MongoUtils;
import io.quarkus.mongodb.reactive.ReactiveMongoCollection;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class UserRepository {
    @Inject
    MongoClientWrapper mongoClientWrapper;

    public Uni<User> add(User user) {
        return MongoUtils.createEntity(getCollection(), user);
    }

    public Uni<PaginatedEntity<User>> getAll(PaginationModel paginationModel, UserFilter userFilter) {
        return MongoUtils.getEntities(getCollection(), paginationModel, userFilter.toBson());
    }

    public Uni<User> getById(String userId) {
        return MongoUtils.getEntity(getCollection(), Filters.eq(User.ID_FIELD, userId));
    }

    public Uni<User> update(String userId, User user) {
        return MongoUtils.updateEntity(getCollection(), Filters.eq(User.ID_FIELD, userId), user);
    }

    public Uni<User> delete(String userId) {
        return MongoUtils.deleteEntity(getCollection(), Filters.eq(User.ID_FIELD, userId));
    }

    private ReactiveMongoCollection<User> getCollection() {
        return mongoClientWrapper.getCollection(MongoCollections.USER, User.class);
    }
}
