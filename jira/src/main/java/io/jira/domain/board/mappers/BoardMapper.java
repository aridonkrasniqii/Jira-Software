package io.jira.domain.board.mappers;

import io.kodelabs.jira.domain.board.dtos.CreateBoard;
import io.kodelabs.jira.domain.board.dtos.UpdateBoard;
import io.kodelabs.jira.domain.board.models.Board;

public class BoardMapper {

    public static Board fromCreate(CreateBoard createBoard) {
        Board board = new Board();
        board.setName(createBoard.getName());
        board.setAdmin(createBoard.getAdmin());
        board.setProject(createBoard.getProject());
        return board;
    }

    public static Board fromUpdate(UpdateBoard updateBoard) {
        Board board = new Board();
        board.setName(updateBoard.getName());
        board.setAdmin(updateBoard.getAdmin());
        board.setProject(updateBoard.getProject());
        return board;
    }
}
