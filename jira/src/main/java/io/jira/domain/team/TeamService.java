package io.jira.domain.team;

import io.jira.common.models.PaginatedEntity;
import io.jira.common.models.PaginationModel;
import io.jira.domain.team.dtos.CreateTeam;
import io.jira.domain.team.dtos.UpdateTeam;
import io.jira.domain.team.exceptions.TeamException;
import io.jira.domain.team.filters.TeamFilter;
import io.jira.domain.team.mappers.TeamMapper;
import io.jira.domain.team.models.Team;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class TeamService {

    @Inject
    TeamRepository repository;


    public Uni<Team> add(CreateTeam team) {
        return repository.add(TeamMapper.mapToTeam(team));
    }

    public Uni<PaginatedEntity<Team>> getAll(PaginationModel paginationModel, TeamFilter teamFilter) {
        return repository.getAll(paginationModel, teamFilter);
    }

    public Uni<Team> getById(String id) {
        return repository.getById(id)
                .onItem().ifNull()
                .failWith(() ->
                    new TeamException());
    }


    public Uni<Team> update(String id, UpdateTeam team) {
        return repository.update(id, TeamMapper.mapToTeam(team))
                .onItem().ifNull()
                .failWith(() ->
                    new TeamException());
    }


    public Uni<Team> delete(String id) {
        return repository.delete(id)
                .onItem().ifNull()
                .failWith(() ->
                    new TeamException());
    }
}
