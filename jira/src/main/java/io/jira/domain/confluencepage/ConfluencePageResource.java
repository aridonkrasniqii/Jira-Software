package io.jira.domain.confluencepage;


import io.jira.common.models.PaginatedEntity;
import io.jira.common.models.PaginationModel;
import io.jira.domain.confluencepage.dtos.CreateConfluencePage;
import io.jira.domain.confluencepage.dtos.UpdateConfluencePage;
import io.jira.domain.confluencepage.filters.ConfluencePageFilter;
import io.jira.domain.confluencepage.models.ConfluencePage;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/confluence-pages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ConfluencePageResource {
    @Inject
    ConfluencePageService service;

    @POST
    public Uni<ConfluencePage> add(CreateConfluencePage confluencePage) {
        return service.add(confluencePage);
    }

    @GET
    public Uni<PaginatedEntity<ConfluencePage>> getAll(@BeanParam PaginationModel paginationModel, @BeanParam ConfluencePageFilter confluencePageFilter) {
        return service.getAll(paginationModel, confluencePageFilter);
    }

    @GET
    @Path("/{id}")
    public Uni<ConfluencePage> getById(@PathParam("id") String id) {
        return service.getById(id);
    }

    @PUT
    @Path("/{id}")
    public Uni<ConfluencePage> update(String id, UpdateConfluencePage confluencePage) {
        return service.update(id, confluencePage);
    }

    @DELETE
    public Uni<ConfluencePage> delete(String id) {
        return service.delete(id);
    }
}
