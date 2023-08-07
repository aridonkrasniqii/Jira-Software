package io.jira.domain.team.exceptions;

import io.jira.common.exceptions.BaseException;
import jakarta.ws.rs.core.Response;

public class TeamException extends BaseException {

    public TeamException() {
    }

    public TeamException(Response.Status status) {
        super(status);
    }

    public TeamException(String messageKey, Response.Status status) {
        super(status, messageKey);
    }

    public TeamException(String messageKey, Response.Status status, String... args) {
        super(status, messageKey, args);
    }
}
