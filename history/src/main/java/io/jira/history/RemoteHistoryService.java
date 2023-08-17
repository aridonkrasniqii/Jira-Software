package io.jira.history;


import io.jira.history.common.mappers.HistoryMapper;
import io.quarkus.grpc.GrpcService;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jira.history.grpc.*;

@GrpcService
public class RemoteHistoryService implements GrpcHistoryService {

    @Inject
    HistoryService historyService;

    @Override
    public Uni<AddHistoryResponse> addHistory(AddHistoryRequest addHistoryRequest) {
        return historyService.add(HistoryMapper.mapFromRequest(addHistoryRequest))
            .map(HistoryMapper::mapToResponse);
    }

    @Override
    public Uni<PaginatedHistory> getHistory(GetHistoryRequest getHistoryRequest) {
        return historyService.getAll(HistoryMapper.mapFromRequest(getHistoryRequest))
            .map(HistoryMapper::mapToResponse);
    }

}
