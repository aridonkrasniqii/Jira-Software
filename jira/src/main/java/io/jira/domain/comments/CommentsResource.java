package io.jira.domain.comments;

import io.jira.common.models.PaginatedEntity;
import io.jira.common.models.PaginationModel;
import io.jira.domain.comments.dtos.CreateComment;
import io.jira.domain.comments.dtos.UpdateComment;
import io.jira.domain.comments.filters.CommentsFilter;
import io.jira.domain.comments.models.Comments;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/comments")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CommentsResource {
    @Inject
    CommentsService service;

    @POST
    public Uni<Comments> add(CreateComment comment) {
        return service.add(comment);
    }

    @GET
    public Uni<PaginatedEntity<Comments>> getAll(@BeanParam PaginationModel paginationModel, @BeanParam CommentsFilter commentsFilter) {
        return service.getAll(paginationModel, commentsFilter);
    }

    @PUT
    @Path("/{id}")
    public Uni<Comments> update(@PathParam("id") String commentId,  UpdateComment comment) {
        return service.update(commentId, comment);
    }

    @DELETE
    @Path("/{id}")
    public Uni<Comments> delete(@PathParam("id") String commentId) {
        return service.delete(commentId);
    }
}
