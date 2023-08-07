package io.jira.domain.weblink;

import io.jira.common.models.PaginatedEntity;
import io.jira.common.models.PaginationModel;
import io.jira.domain.weblink.dtos.CreateWebLink;
import io.jira.domain.weblink.dtos.UpdateWebLink;
import io.jira.domain.weblink.exceptions.WebLinkException;
import io.jira.domain.weblink.filters.WebLinkFilter;
import io.jira.domain.weblink.mappers.WebLinkMapper;
import io.jira.domain.weblink.models.WebLink;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.validation.Valid;


@ApplicationScoped
public class WebLinkService {
    @Inject
    WebLinkRepository repository;

    public Uni<WebLink> add(@Valid CreateWebLink webLink) {
        return repository.add(WebLinkMapper.mapToWebLink(webLink));
    }

    public Uni<PaginatedEntity<WebLink>> getAll(PaginationModel paginationModel, WebLinkFilter webLinkFilter) {
        return repository.getAll(paginationModel, webLinkFilter);
    }

    public Uni<WebLink> getById(String id) {
        return repository.getById(id)
            .onItem().ifNull()
            .failWith(() ->
                new WebLinkException());
    }

    public Uni<WebLink> update(String id, @Valid UpdateWebLink weblink) {
        return repository.update(id, WebLinkMapper.mapToWebLink(weblink))
            .onItem().ifNull()
            .failWith(() ->
                new WebLinkException());
    }

    public Uni<WebLink> delete(String id) {
        return repository.delete(id)
            .onItem().ifNull()
            .failWith(() ->
                new WebLinkException());
    }
}
