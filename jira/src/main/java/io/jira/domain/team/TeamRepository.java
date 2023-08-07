package io.jira.domain.team;

import com.mongodb.client.model.Filters;
import io.jira.common.models.PaginatedEntity;
import io.jira.common.models.PaginationModel;
import io.jira.domain.team.filters.TeamFilter;
import io.jira.domain.team.models.Team;
import io.jira.mongo.MongoClientWrapper;
import io.jira.mongo.MongoCollections;
import io.jira.mongo.MongoUtils;
import io.quarkus.mongodb.reactive.ReactiveMongoCollection;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class TeamRepository {

    @Inject
    MongoClientWrapper mongoClientWrapper;

    public Uni<Team> add(Team team) {
        return MongoUtils.createEntity(getCollection(), team);
    }

    public Uni<PaginatedEntity<Team>> getAll(PaginationModel paginationModel, TeamFilter teamFilter) {
        return MongoUtils.getEntities(getCollection(), paginationModel, teamFilter.toBson());
    }

    public Uni<Team> getById(String id) {
        return MongoUtils.getEntity(getCollection(), Filters.eq(Team.ID_FIELD , id));
    }

    public Uni<Team> update(String id, Team team) {
        return MongoUtils.updateEntity(getCollection(), Filters.eq(Team.ID_FIELD, id), team);
    }

    public Uni<Team> delete(String id) {
        return MongoUtils.deleteEntity(getCollection(), Filters.eq(Team.ID_FIELD, id));
    }

    private ReactiveMongoCollection<Team> getCollection() {
        return mongoClientWrapper.getCollection(MongoCollections.TEAM, Team.class);
    }

}
