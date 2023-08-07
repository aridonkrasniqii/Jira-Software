package io.jira.domain.board;

import io.kodelabs.jira.common.models.PaginatedEntity;
import io.kodelabs.jira.common.pagination.PaginationModel;
import io.kodelabs.jira.domain.board.dtos.CreateBoard;
import io.kodelabs.jira.domain.board.dtos.UpdateBoard;
import io.kodelabs.jira.domain.board.models.Board;
import io.kodelabs.jira.domain.board.wrappers.FilterBoardWrapper;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/boards")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BoardResource {
    @Inject
    BoardService service;

    @POST
    public Uni<Board> createBoard(CreateBoard board) {
        return service.createBoard(board);
    }

    @GET
    public Uni<PaginatedEntity<Board>> getAllBoards(@BeanParam PaginationModel paginationModel, @BeanParam FilterBoardWrapper filterBoardWrapper) {
        return service.getAllBoards(paginationModel, filterBoardWrapper);
    }

    @GET
    @Path("/{id}")
    public Uni<Board> getBoardById(@PathParam("id") String id) {
        return service.getBoardById(id);
    }

    @PUT
    @Path("/{id}")
    public Uni<Board> updateBoard(@PathParam("id") String id, UpdateBoard board) {
        return service.updateBoard(id, board);
    }

    @DELETE
    @Path("/{id}")
    public Uni<Board> deleteBoard(@PathParam("id") String id) {
        return service.deleteBoard(id);
    }
}

