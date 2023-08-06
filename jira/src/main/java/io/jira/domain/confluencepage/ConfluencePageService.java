package io.jira.domain.confluencepage;


import io.jira.common.exceptions.ExceptionMessageKey;
import io.jira.common.models.PaginatedEntity;
import io.jira.common.models.PaginationModel;
import io.jira.domain.confluencepage.dtos.CreateConfluencePage;
import io.jira.domain.confluencepage.dtos.UpdateConfluencePage;
import io.jira.domain.confluencepage.exceptions.ConfluencePageException;
import io.jira.domain.confluencepage.filters.ConfluencePageFilter;
import io.jira.domain.confluencepage.mappers.ConfluencePageMapper;
import io.jira.domain.confluencepage.models.ConfluencePage;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.core.Response;


@ApplicationScoped
public class ConfluencePageService {
    @Inject
    ConfluencePageRepository repository;

    public Uni<ConfluencePage> add(@Valid CreateConfluencePage confluencePage) {
        return repository.add(ConfluencePageMapper.mapToConfluencePage(confluencePage));
    }

    public Uni<PaginatedEntity<ConfluencePage>> getAll(PaginationModel paginationModel, ConfluencePageFilter confluencePageFilter) {
        return repository.getAll(paginationModel, confluencePageFilter);
    }

    public Uni<ConfluencePage> getById(String id) {
        return repository.getById(id)
            .onItem().ifNull()
            .failWith(() ->
                new ConfluencePageException(ExceptionMessageKey.ENTITY_NOT_FOUND, Response.Status.NOT_FOUND));
    }

    public Uni<ConfluencePage> update(String id, @Valid UpdateConfluencePage confluencePage) {
        return repository.update(id, ConfluencePageMapper.mapToConfluencePage(confluencePage))
            .onItem().ifNull()
            .failWith(() ->
                new ConfluencePageException(ExceptionMessageKey.ENTITY_NOT_UPDATED, Response.Status.BAD_REQUEST));
    }

    public Uni<ConfluencePage> delete(String confluencePageId) {
        return repository.delete(confluencePageId)
            .onItem().ifNull()
            .failWith(() ->
                new ConfluencePageException(ExceptionMessageKey.ENTITY_NOT_DELETED, Response.Status.BAD_REQUEST));
    }
}
