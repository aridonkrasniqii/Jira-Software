package io.jira.domain.issue;

import io.jira.common.models.PaginatedEntity;
import io.jira.common.models.PaginationModel;
import io.jira.domain.issue.dtos.CreateIssue;
import io.jira.domain.issue.dtos.UpdateIssue;
import io.jira.domain.issue.models.Issue;
import io.jira.domain.issue.services.ChildIssuesService;
import io.jira.domain.issue.services.EpicService;
import io.jira.domain.issue.wrappers.IssueFilter;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class IssueService {

    @Inject
    IssueRepository issueRepository;

    @Inject
    EpicService epicService;

    @Inject
    ChildIssuesService childIssuesService;

    public Uni<Issue> add(CreateIssue createIssue) {
        return createIssue(createIssue);
    }


    private Uni<Issue> createIssue(CreateIssue createIssue) {
        return switch (createIssue.getType()) {
            case EPIC -> epicService.createEpic(createIssue);
            case SUBTASK -> childIssuesService.createSubtask(createIssue);
            default -> childIssuesService.createIssue(createIssue);
        };
    }

    public Uni<PaginatedEntity<Issue>> getAll(PaginationModel paginationModel, IssueFilter issueFilter) {
        return issueRepository.getAll(paginationModel, issueFilter);
    }

    public Uni<Issue> getById(String issueId) {
        return issueRepository.getById(issueId);
    }

    public Uni<Issue> update(String issueId, UpdateIssue updateIssue) {
        return updateIssue(issueId, updateIssue);
    }

    public Uni<Issue> updateIssue(String issueId, UpdateIssue updateIssue) {
        return switch(updateIssue.getType()){
            case "EPIC" -> epicService.updateEpic(issueId, updateIssue);
            case "SUBTASK" -> childIssuesService.updateSubtask(issueId, updateIssue);
            default -> childIssuesService.updateIssue(issueId, updateIssue);
        };
    }

    public Uni<Issue> delete(String issueId) {
        return issueRepository.delete(issueId);
    }

}
