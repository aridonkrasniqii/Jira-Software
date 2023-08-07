package io.jira.domain.team;

import io.jira.common.models.PaginatedEntity;
import io.jira.common.models.PaginationModel;
import io.jira.domain.team.dtos.CreateTeam;
import io.jira.domain.team.dtos.UpdateTeam;
import io.jira.domain.team.filters.TeamFilter;
import io.jira.domain.team.models.Team;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/teams")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TeamResource {
    @Inject
    TeamService service;

    @POST
    public Uni<Team> add(CreateTeam team) {
        return service.add(team);
    }

    @GET
    public Uni<PaginatedEntity<Team>> getAll(@BeanParam PaginationModel paginationModel, @BeanParam TeamFilter teamFilter) {
        return service.getAll(paginationModel, teamFilter);
    }

    @GET
    @Path("/{id}")
    public Uni<Team> getById(@PathParam("id") String id) {
        return service.getById(id);
    }

    @PUT
    @Path("/{id}")
    public Uni<Team> update(@PathParam("id") String id, UpdateTeam team) {
        return service.update(id, team);
    }

    @DELETE
    @Path("/{id}")
    public Uni<Team> delete(@PathParam("id") String id) {
        return service.delete(id);
    }

}
