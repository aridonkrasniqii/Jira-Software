package io.jira.domain.issue.services;

import io.jira.domain.issue.IssueRepository;
import io.jira.domain.issue.dtos.CreateIssue;
import io.jira.domain.issue.dtos.UpdateIssue;
import io.jira.domain.issue.models.Issue;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class EpicService {

    @Inject
    IssueRepository issueRepository;

    public Uni<Issue> createEpic(CreateIssue createIssue){
        // TODO: handle logic for epic creation
        return Uni.createFrom().nullItem();
    }

    public Uni<Issue> updateEpic(String issueId, UpdateIssue updateIssue) {
        // TODO: handle logic for epic update
        return Uni.createFrom().nullItem();
    }

}
