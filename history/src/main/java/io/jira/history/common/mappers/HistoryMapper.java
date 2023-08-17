package io.jira.history.common.mappers;

import io.jira.history.History;
import io.jira.history.common.models.PaginatedEntity;
import io.jira.history.common.models.PaginationModel;
import jira.history.grpc.AddHistoryRequest;
import jira.history.grpc.AddHistoryResponse;
import jira.history.grpc.GetHistoryRequest;
import jira.history.grpc.PaginatedHistory;

public class HistoryMapper {


    public static History mapFromRequest(AddHistoryRequest addHistoryRequest) {
        return new History();
    }

    public static PaginationModel mapFromRequest(GetHistoryRequest getHistoryRequest) {
        return new PaginationModel();
    }

    public static AddHistoryResponse mapToResponse(History history) {
        return AddHistoryResponse.newBuilder().build();
    }

    public static PaginatedHistory mapToResponse(PaginatedEntity<History> paginatedHistory) {
        return PaginatedHistory.newBuilder().build();
    }
}
