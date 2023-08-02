package io.jira.domain.issue.services;

import io.jira.domain.issue.IssueRepository;
import io.jira.domain.issue.dtos.CreateIssue;
import io.jira.domain.issue.dtos.UpdateIssue;
import io.jira.domain.issue.models.Issue;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ChildIssuesService {

    @Inject
    IssueRepository issueRepository;

    public Uni<Issue> createIssue(CreateIssue createIssue) {
        // TODO: handle logic for child issue creation
        return Uni.createFrom().nullItem();
    }

    public Uni<Issue> createSubtask(CreateIssue createIssue) {
        // TODO: handle logic for subtask creation
        return Uni.createFrom().nullItem();
    }

    public Uni<Issue> updateIssue(String issueId, UpdateIssue updateIssue) {
        // TODO: handle logic for issue update
        return Uni.createFrom().nullItem();
    }

    public Uni<Issue> updateSubtask(String issueId, UpdateIssue updateIssue) {
        // TODO: handle logic for subtask update
        return Uni.createFrom().nullItem();
    }
}
