package io.jira.domain.comments;

import com.mongodb.client.model.Filters;
import io.jira.common.models.PaginatedEntity;
import io.jira.common.models.PaginationModel;
import io.jira.domain.comments.filters.CommentsFilter;
import io.jira.domain.comments.models.Comments;
import io.jira.mongo.MongoClientWrapper;
import io.jira.mongo.MongoCollections;
import io.jira.mongo.MongoUtils;
import io.quarkus.mongodb.reactive.ReactiveMongoCollection;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class CommentsRepository {
    @Inject
    MongoClientWrapper mongoClientWrapper;

    public Uni<Comments> add(Comments comment) {
        return MongoUtils.createEntity(getCollection(), comment);
    }

    public Uni<PaginatedEntity<Comments>> getAll(PaginationModel paginationModel , CommentsFilter commentsFilter) {
        return MongoUtils.getEntities(getCollection(), paginationModel, commentsFilter.toBson());
    }

    public Uni<Comments> update(String commentId, Comments comment) {
        return MongoUtils.updateEntity(getCollection(), Filters.eq(Comments.ID_FIELD, commentId), comment);
    }

//    public Uni<Comments> updateIssueComment(String issueId, String commentId, Comments comment) {
//        return MongoUtils.updateEntity(collection(), and(eq(Comments.FIELD_ID, commentId), eq(Comments.FIELD_ISSUE_ID, issueId)), comment);
//    }

    public Uni<Comments> delete(String commentId) {
        return MongoUtils.deleteEntity(getCollection(), Filters.eq(Comments.ID_FIELD, commentId));
    }

//    public Uni<Comments> deleteIssueComment(String issueId, String commentId) {
//        return MongoUtils.deleteEntity(collection(), and(eq(Comments.FIELD_ID, commentId), eq(Comments.FIELD_ISSUE_ID, issueId)));
//    }
    public ReactiveMongoCollection<Comments> getCollection() {
        return mongoClientWrapper.getCollection(MongoCollections.COMMENTS, Comments.class);
    }
}
