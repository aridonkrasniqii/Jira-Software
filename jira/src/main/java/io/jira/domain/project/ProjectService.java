package io.jira.domain.project;


import io.jira.common.models.PaginatedEntity;
import io.jira.common.models.PaginationModel;
import io.jira.domain.project.dtos.CreateProject;
import io.jira.domain.project.dtos.UpdateProject;
import io.jira.domain.project.exceptions.ProjectException;
import io.jira.domain.project.filters.ProjectFilter;
import io.jira.domain.project.mappers.ProjectMapper;
import io.jira.domain.project.models.Project;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class ProjectService {

    @Inject
    ProjectRepository repository;

    public Uni<Project> add(@Valid CreateProject project) {
        return repository.add(ProjectMapper.mapToProject(project));
    }

    public Uni<PaginatedEntity<Project>> getAll(PaginationModel paginationModel, ProjectFilter projectFilter) {
        return repository.getAll(paginationModel, projectFilter);
    }

    public Uni<Project> getById(String id) {
        return repository.getById(id)
                .onItem().ifNull()
                .failWith(() -> new NotFoundException(ProjectException.NOT_FOUND));
    }

    public Uni<Project> update(String id, UpdateProject project) {
        return repository.update(id, ProjectMapper.mapToProject(project))
                .onItem().ifNull()
                .failWith(() -> new NotFoundException(ProjectException.NOT_FOUND));
    }

    public Uni<Project> delete(String id) {
        return repository.delete(id)
                .onItem().ifNull()
                .failWith(() -> new NotFoundException(ProjectException.NOT_FOUND));
    }
}
