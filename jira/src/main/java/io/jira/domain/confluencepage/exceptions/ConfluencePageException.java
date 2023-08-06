package io.jira.domain.confluencepage.exceptions;

import io.jira.common.exceptions.BaseException;
import jakarta.ws.rs.core.Response;

public class ConfluencePageException extends BaseException {

    public ConfluencePageException(String messageKey, Response.Status status) {
        super( status, messageKey, "Confluence Page");
    }

    public ConfluencePageException(String messageKey, Response.Status status, String ...args ) {
        super(status ,messageKey, args);
    }

}
