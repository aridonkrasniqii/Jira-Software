package io.jira.common.utils;

import io.jira.common.exceptions.BaseException;
import io.jira.common.exceptions.ExceptionMessageKey;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.core.Response;

public class MutinyUtils {
    public static <T> Uni<T> onUniHandler(T entity, String entityName) {
        return Uni.createFrom().item(entity)
            .onItem().ifNull()
            .failWith(() -> new BaseException(Response.Status.BAD_REQUEST, ExceptionMessageKey.ENTITY_NOT_FOUND, entityName));
    }
}
