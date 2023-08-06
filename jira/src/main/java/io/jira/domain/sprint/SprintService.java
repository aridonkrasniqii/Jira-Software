package io.jira.domain.sprint;


import io.jira.common.models.PaginatedEntity;
import io.jira.common.models.PaginationModel;
import io.jira.domain.sprint.dtos.CreateSprint;
import io.jira.domain.sprint.dtos.UpdateSprint;
import io.jira.domain.sprint.exceptions.SprintException;
import io.jira.domain.sprint.filters.SprintFilter;
import io.jira.domain.sprint.mappers.SprintMapper;
import io.jira.domain.sprint.models.Sprint;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class SprintService {

    @Inject
    SprintRepository repository;

    public Uni<Sprint> add(CreateSprint sprint) {
        return repository.add(SprintMapper.mapToSprint(sprint));
    }

    public Uni<PaginatedEntity<Sprint>> getAll(PaginationModel paginationModel, SprintFilter sprintFilter) {
        return repository.getAll(paginationModel, sprintFilter);
    }

    public Uni<Sprint> getById(String id) {
        return repository.getById(id)
                .onItem().ifNull()
                .failWith(() -> new NotFoundException(SprintException.NOT_FOUND));
    }

    public Uni<Sprint> update(String id, UpdateSprint sprint) {
        return repository.update(id, SprintMapper.mapToSprint(sprint))
                .onItem().ifNull()
                .failWith(() -> new NotFoundException(SprintException.NOT_FOUND));
    }

    public Uni<Sprint> delete(String id) {
        return repository.delete(id)
                .onItem().ifNull()
                .failWith(() -> new NotFoundException(SprintException.NOT_FOUND));
    }
}
