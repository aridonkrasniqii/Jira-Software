package io.jira.domain.sprint;

import io.jira.common.models.PaginatedEntity;
import io.jira.common.models.PaginationModel;
import io.jira.domain.issue.models.IssueReference;
import io.jira.domain.sprint.dtos.CreateSprint;
import io.jira.domain.sprint.dtos.UpdateSprint;
import io.jira.domain.sprint.filters.SprintFilter;
import io.jira.domain.sprint.models.Sprint;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/sprints")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SprintResource {

    @Inject
    SprintService service;

    @POST
    public Uni<Sprint> add(CreateSprint sprint) {
        return service.add(sprint);
    }

    @GET
    public Uni<PaginatedEntity<Sprint>> getAll(@BeanParam PaginationModel paginationModel, @BeanParam SprintFilter sprintFilter) {
        return service.getAll(paginationModel, sprintFilter);
    }

    @GET
    @Path("/{id}")
    public Uni<Sprint> getById(@PathParam("id") String id) {
        return service.getById(id);
    }

    @PUT
    @Path("/{id}")
    public Uni<Sprint> update(@PathParam("id") String id, UpdateSprint sprint) {
        return service.update(id, sprint);
    }

    @DELETE
    @Path("/{id}")
    public Uni<Sprint> delete(@PathParam("id") String id) {
        return service.delete(id);
    }

    @POST
    @Path("/{sprintId}/issues")
    public Uni<Sprint> addIssueToSprint(@PathParam("sprintId") String sprintId, @QueryParam("issueId") String issueId) {
        return null;
    }

    @GET
    @Path("/{sprintId}/issues")
    public Uni<List<IssueReference>> getSprintIssues(@PathParam("sprintId") String sprintId) {
        return null;
    }

    @PUT
    @Path("/{sprintId}/issues")
    public Uni<List<IssueReference>> update(@PathParam("sprintId") String sprintId) {
        return null;
    }

    @DELETE
    @Path("/{sprintId}/issues/{issueId}")
    public Uni<IssueReference> deleteIssueFromSprint(@PathParam("sprintId") String sprintId, @PathParam("issueId") String issueId) {
        return null;
    }


}
