package io.jira.domain.issue;

import com.mongodb.client.model.Filters;
import io.jira.common.models.PaginatedEntity;
import io.jira.common.models.PaginationModel;
import io.jira.domain.issue.models.Issue;
import io.jira.domain.issue.wrappers.IssueFilter;
import io.jira.mongo.MongoClientWrapper;
import io.jira.mongo.MongoCollections;
import io.jira.mongo.MongoUtils;
import io.quarkus.mongodb.reactive.ReactiveMongoCollection;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class IssueRepository {

    @Inject
    MongoClientWrapper mongoClientWrapper;

    public Uni<Issue> add(Issue issue) {
        return MongoUtils.createEntity(getCollection(), issue);
    }

    public Uni<PaginatedEntity<Issue>> getAll(PaginationModel paginationModel, IssueFilter issueFilter) {
        return MongoUtils.getEntities(getCollection(), paginationModel, issueFilter.toBson());
    }

    public Uni<Issue> getById(String issueId) {
        return MongoUtils.getEntity(getCollection(), Filters.eq(Issue.ID_FIELD, issueId));
    }

    public Uni<Issue> update(String issueId, Issue issue) {
        return MongoUtils.updateEntity(getCollection(), Filters.eq(Issue.ID_FIELD, issueId), issue);
    }

    public Uni<Issue> delete(String issueId) {
        return MongoUtils.deleteEntity(getCollection(), Filters.eq(Issue.ID_FIELD, issueId));
    }

    public ReactiveMongoCollection<Issue> getCollection() {
        return mongoClientWrapper.getCollection(MongoCollections.ISSUE, Issue.class);
    }
}
