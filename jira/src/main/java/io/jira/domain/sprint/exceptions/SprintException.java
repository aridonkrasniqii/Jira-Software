package io.jira.domain.sprint.exceptions;

import io.jira.common.exceptions.BaseException;
import jakarta.ws.rs.core.Response;

public class SprintException extends BaseException {
    public static final String NOT_FOUND = "Sprint was not found";

    public SprintException() {
    }

    public SprintException(Response.Status status) {
        super(status);
    }

    public SprintException(String messageKey, Response.Status status) {
        super(status, messageKey);
    }

    public SprintException(String messageKey, Response.Status status, String... args) {
        super(status, messageKey, args);
    }
}
