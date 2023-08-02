package io.jira.common.exceptions;

import com.fasterxml.jackson.databind.node.ObjectNode;
import io.jira.common.mappers.MultiLanguageMapper;
import io.jira.common.utils.JsonSerializer;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.logging.Logger;
import org.jboss.resteasy.reactive.server.ServerExceptionMapper;

import static io.jira.common.utils.Utils.notNull;

public class ExceptionHandler {

    private static final Logger logger = Logger.getLogger(ExceptionHandler.class);

    @Inject
    MultiLanguageMapper languageMapper;


    @ServerExceptionMapper(BaseException.class)
    public Uni<Response> toUniResponse(BaseException baseException) {
        ObjectNode objectNode = JsonSerializer.createObjectNode();

        objectNode.put("code", baseException.getStatus().getStatusCode());

        String message;
        if (notNull(baseException.messageKey)) {
            message = languageMapper.getLocaleMessage(baseException.messageKey, baseException.getArgs());
        } else {
            message = baseException.getMessage();
        }

        objectNode.put("message", message);

        if (baseException.getStatus().getFamily() == Response.Status.Family.SERVER_ERROR) {
            logger.error("Server error", baseException.getCause());
        }

        return Uni.createFrom()
            .item(
                Response.status(baseException.getStatus().getStatusCode(), baseException.getMessage())
                    .entity(objectNode.toString())
                    .type(MediaType.APPLICATION_JSON)
                    .build()
            );

    }
}
