package io.jira.domain.weblink.exceptions;

import io.jira.common.exceptions.BaseException;
import jakarta.ws.rs.core.Response;

public class WebLinkException extends BaseException  {

    public WebLinkException() {
    }

    public WebLinkException(Response.Status status) {
        super(status);
    }

    public WebLinkException(String messageKey, Response.Status status) {
        super(status, messageKey);
    }

    public WebLinkException(String messageKey, Response.Status status, String... args) {
        super(status, messageKey, args);
    }
}
