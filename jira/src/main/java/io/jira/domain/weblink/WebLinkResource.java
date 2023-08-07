package io.jira.domain.weblink;

import io.jira.common.models.PaginatedEntity;
import io.jira.common.models.PaginationModel;
import io.jira.domain.weblink.dtos.CreateWebLink;
import io.jira.domain.weblink.dtos.UpdateWebLink;
import io.jira.domain.weblink.filters.WebLinkFilter;
import io.jira.domain.weblink.models.WebLink;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/weblinks")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class WebLinkResource {
    @Inject
    WebLinkService service;

    @POST
    public Uni<WebLink> add(CreateWebLink webLink) {
        return service.add(webLink);
    }

    @GET
    public Uni<PaginatedEntity<WebLink>> getAll(@BeanParam PaginationModel paginationModel, @BeanParam WebLinkFilter webLinkFilter) {
        return  service.getAll(paginationModel, webLinkFilter);
    }

    @GET
    @Path("/{id}")
    public Uni<WebLink> getById(@PathParam("id") String id) {
        return service.getById(id);
    }


    @PUT
    @Path("/{id}")
    public Uni<WebLink> update(@PathParam("id") String id, UpdateWebLink weblink) {
        return service.update(id, weblink);
    }

    @DELETE
    @Path("/{id}")
    public Uni<WebLink> delete(@PathParam("id") String id) {
        return service.delete(id);
    }
}
