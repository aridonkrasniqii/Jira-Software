package io.jira.domain.project;


import com.mongodb.client.model.Filters;
import io.jira.common.models.PaginatedEntity;
import io.jira.common.models.PaginationModel;
import io.jira.domain.project.filters.ProjectFilter;
import io.jira.domain.project.models.Project;
import io.jira.mongo.MongoClientWrapper;
import io.jira.mongo.MongoCollections;
import io.jira.mongo.MongoUtils;
import io.quarkus.mongodb.reactive.ReactiveMongoCollection;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;


@ApplicationScoped
public class ProjectRepository {

    @Inject
    MongoClientWrapper mongoClientWrapper;

    public Uni<Project> add(Project project) {
        return MongoUtils.createEntity(getCollection(), project);
    }

    public Uni<PaginatedEntity<Project>> getAll(PaginationModel paginationModel, ProjectFilter projectFilter) {
        return MongoUtils.getEntities(getCollection(), paginationModel, projectFilter.toBson());
    }

    public Uni<Project> getById(String id) {
        return MongoUtils.getEntity(getCollection(), Filters.eq(Project.ID_FIELD, id));
    }

    public Uni<Project> update(String id, Project project) {
        return MongoUtils.updateEntity(getCollection(), Filters.eq(Project.ID_FIELD, id), project);
    }

    public Uni<Project> delete(String id) {
        return MongoUtils.deleteEntity(getCollection(), Filters.eq(Project.ID_FIELD, id));
    }

    private ReactiveMongoCollection<Project> getCollection() {
        return mongoClientWrapper.getCollection(MongoCollections.PROJECT, Project.class);
    }
}
