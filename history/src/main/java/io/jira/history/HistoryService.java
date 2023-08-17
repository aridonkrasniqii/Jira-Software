package io.jira.history;

import io.jira.history.common.models.PaginatedEntity;
import io.jira.history.common.models.PaginationModel;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class HistoryService {
    @Inject
    HistoryRepository historyRepository;

    public Uni<History> add(History history) { // This needs to be a create grpc item
        return historyRepository.add(history);
    }

    public Uni<PaginatedEntity<History>> getAll(PaginationModel paginationModel) {
        return historyRepository.getAll(paginationModel);
    }

    public Uni<History> update(String historyId, History history) { // This also needs to be a update grpc item
        return historyRepository.update(historyId, history);
    }

    public Uni<History> delete(String historyId) {
        return historyRepository.delete(historyId);
    }

}
