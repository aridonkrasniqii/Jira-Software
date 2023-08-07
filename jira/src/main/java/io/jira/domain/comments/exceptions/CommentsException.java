package io.jira.domain.comments.exceptions;

import io.jira.common.exceptions.BaseException;
import jakarta.ws.rs.core.Response;

public class CommentsException extends BaseException {

    public CommentsException() {
    }

    public CommentsException(Response.Status status) {
        super(status);
    }

    public CommentsException(String messageKey, Response.Status status) {
        super(status, messageKey);
    }

    public CommentsException(String messageKey, Response.Status status, String... args) {
        super(status, messageKey, args);
    }
}
