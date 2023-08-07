package io.jira.domain.board;


import io.kodelabs.jira.common.models.PaginatedEntity;
import io.kodelabs.jira.common.pagination.PaginationModel;
import io.kodelabs.jira.domain.board.dtos.CreateBoard;
import io.kodelabs.jira.domain.board.dtos.UpdateBoard;
import io.kodelabs.jira.domain.board.exceptions.BoardException;
import io.kodelabs.jira.domain.board.mappers.BoardMapper;
import io.kodelabs.jira.domain.board.models.Board;
import io.kodelabs.jira.domain.board.wrappers.FilterBoardWrapper;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class BoardService {

    @Inject
    BoardRepository repository;

    public Uni<Board> createBoard(@Valid CreateBoard board) {
        return repository.createBoard(BoardMapper.fromCreate(board));
    }

    public Uni<PaginatedEntity<Board>> getAllBoards(PaginationModel paginationModel, FilterBoardWrapper filterBoardWrapper) {
        return repository.getAllBoards(paginationModel, filterBoardWrapper);
    }

    public Uni<Board> getBoardById(String id) {
        return repository.getBoardById(id)
                .onItem().ifNull()
                .failWith(() -> new NotFoundException(BoardException.NOT_FOUND));
    }

    public Uni<Board> updateBoard(String id, @Valid UpdateBoard board) {
        return repository.updateBoard(id, BoardMapper.fromUpdate(board))
                .onItem().ifNull()
                .failWith(() -> new NotFoundException(BoardException.NOT_FOUND));
    }


    public Uni<Board> deleteBoard(String id) {
        return repository.deleteBoard(id)
                .onItem().ifNull()
                .failWith(() -> new NotFoundException(BoardException.NOT_FOUND));
    }
}
