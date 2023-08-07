package io.jira.domain.comments.mappers;

import io.jira.domain.comments.dtos.CreateComment;
import io.jira.domain.comments.dtos.UpdateComment;
import io.jira.domain.comments.models.Comments;

public class CommentMapper {
    public static Comments mapToComments(CreateComment createComment) {
        Comments comment = new Comments();
        comment.setIssue(createComment.getIssue());
        comment.setAuthor(createComment.getAuthor());
        comment.setTextBody(createComment.getTextBody());
        return comment;
    }

    public static Comments mapToComments(UpdateComment updateComment) {
        Comments comment = new Comments();
        comment.setIssue(updateComment.getIssue());
        comment.setAuthor(updateComment.getAuthor());
        comment.setTextBody(updateComment.getTextBody());
        return comment;
    }
}
