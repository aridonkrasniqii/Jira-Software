package io.jira.domain.comments;

import io.jira.common.models.PaginatedEntity;
import io.jira.common.models.PaginationModel;
import io.jira.domain.comments.dtos.CreateComment;
import io.jira.domain.comments.dtos.UpdateComment;
import io.jira.domain.comments.exceptions.CommentsException;
import io.jira.domain.comments.filters.CommentsFilter;
import io.jira.domain.comments.mappers.CommentMapper;
import io.jira.domain.comments.models.Comments;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class CommentsService {
    @Inject
    CommentsRepository repository;

    public Uni<Comments> add(@Valid CreateComment comment) {
        return repository.add(CommentMapper.mapToComments(comment));
    }

    public Uni<PaginatedEntity<Comments>> getAll(PaginationModel paginationModel, CommentsFilter commentsFilter) {
        return repository.getAll(paginationModel, commentsFilter);
    }

//    public Uni<PaginatedEntity<Comments>> getIssueAllComments(String issueId, PaginationModel paginationModel) {
//        return repository.getIssueAllComments(issueId, paginationModel);
//    }

    public Uni<Comments> update(String commentId , @Valid UpdateComment comment) {
        return repository.update(commentId, CommentMapper.mapToComments(comment))
                .onItem().ifNull()
                .failWith(() ->
                    new CommentsException());
    }

//    public Uni<Comments> updateIssueComment(String issueId, String commentId , @Valid UpdateComment comment) {
//        return repository.updateIssueComment(issueId, commentId, CommentMapper.fromUpdate(comment))
//                .onItem().ifNull()
//                .failWith(() ->
//                    new CommentsException());
//    }

//    public Uni<Comments> deleteIssueComment(String issueId, String commentId) {
//        return repository.deleteIssueComment(issueId, commentId)
//                .onItem().ifNull()
//                .failWith(() -> new AppServiceException(Response.Status.BAD_REQUEST, CommentsException.COMMENT_NOT_DELETED));
//    }

    public Uni<Comments> delete(String commentId) {
        return repository.delete(commentId)
                .onItem().ifNull()
                .failWith(() ->
                    new CommentsException());
    }
}
