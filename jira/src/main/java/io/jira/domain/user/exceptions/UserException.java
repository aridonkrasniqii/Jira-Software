package io.jira.domain.user.exceptions;

import io.jira.common.exceptions.BaseException;
import jakarta.ws.rs.core.Response;

public class UserException extends BaseException {


    public UserException() {
    }

    public UserException(Response.Status status) {
        super(status);
    }

    public UserException(String messageKey, Response.Status status) {
        super(status, messageKey);
    }

    public UserException(String messageKey, Response.Status status, String... args) {
        super(status, messageKey, args);
    }
}
