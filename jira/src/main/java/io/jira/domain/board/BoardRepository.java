package io.jira.domain.board;


import io.kodelabs.jira.common.models.PaginatedEntity;
import io.kodelabs.jira.common.pagination.PaginationModel;
import io.kodelabs.jira.domain.board.models.Board;
import io.kodelabs.jira.domain.board.wrappers.FilterBoardWrapper;
import io.kodelabs.jira.mongodb.MongoClientWrapper;
import io.kodelabs.jira.mongodb.MongoUtils;
import io.quarkus.mongodb.reactive.ReactiveMongoCollection;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class BoardRepository {

    @Inject
    MongoClientWrapper clientWrapper;

    public Uni<Board> createBoard(Board board) {
        return MongoUtils.createEntity(collection(), board);
    }

    public Uni<PaginatedEntity<Board>> getAllBoards(PaginationModel paginationModel, FilterBoardWrapper filterBoardWrapper) {
        return MongoUtils.getEntities(collection(), paginationModel, filterBoardWrapper.toBson());
    }

    public Uni<Board> getBoardById(String id) {
        return MongoUtils.getEntityById(collection(), id);
    }

    public Uni<Board> updateBoard(String id, Board board) {
        return MongoUtils.updateEntity(collection(), id, board);
    }

    public Uni<Board> deleteBoard(String id){
        return MongoUtils.deleteEntity(collection(), id);
    }

    public ReactiveMongoCollection<Board> collection() {
        return clientWrapper.getCollection("board", Board.class);
    }
}
