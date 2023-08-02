package io.jira.common;

import io.smallrye.mutiny.Uni;
import io.vertx.core.http.HttpHeaders;
import io.vertx.core.http.HttpServerRequest;
import jakarta.inject.Inject;
import jakarta.ws.rs.container.ResourceInfo;
import org.jboss.resteasy.reactive.server.ServerRequestFilter;

import java.util.Locale;

import static io.jira.common.utils.Utils.notNull;

public class RequestFilter {

    @Inject
    ContextWrapper contextWrapper;

    @ServerRequestFilter()
    public Uni<Void> interceptRequest(ResourceInfo resourceInfo, HttpServerRequest httpServerRequest) {
        if(notNull(httpServerRequest.getHeader(HttpHeaders.ACCEPT_LANGUAGE))) {
            contextWrapper.setLocale(Locale.forLanguageTag(httpServerRequest.getHeader(HttpHeaders.ACCEPT_LANGUAGE)));
        } else {
            contextWrapper.setLocale(Locale.ENGLISH);
        }


        return Uni.createFrom().voidItem();
    }


}
