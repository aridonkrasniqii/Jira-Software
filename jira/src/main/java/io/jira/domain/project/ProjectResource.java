package io.jira.domain.project;


import io.jira.common.models.PaginatedEntity;
import io.jira.common.models.PaginationModel;
import io.jira.domain.project.dtos.CreateProject;
import io.jira.domain.project.dtos.UpdateProject;
import io.jira.domain.project.filters.ProjectFilter;
import io.jira.domain.project.models.Project;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/projects")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProjectResource {

    @Inject
    ProjectService service;
    @POST
    public Uni<Project> add(CreateProject project) {
        return service.add(project);
    }

    @GET
    public Uni<PaginatedEntity<Project>> getAll(@BeanParam PaginationModel paginationModel, @BeanParam ProjectFilter projectFilter) {
        return service.getAll(paginationModel, projectFilter);
    }

    @GET
    @Path("/{id}")
    public Uni<Project> getById(@PathParam("id") String id) {
        return service.getById(id);
    }

    @PUT
    @Path("/{id}")
    public Uni<Project> update(@PathParam("id") String id, UpdateProject project) {
        return service.update(id, project);
    }

    @DELETE
    @Path("/{id}")
    public Uni<Project> delete(@PathParam("id") String id) {
        return service.delete(id);
    }

}
