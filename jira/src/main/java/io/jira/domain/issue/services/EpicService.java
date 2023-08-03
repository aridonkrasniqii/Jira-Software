package io.jira.domain.issue.services;

import io.jira.domain.issue.IssueRepository;
import io.jira.domain.issue.dtos.CreateIssue;
import io.jira.domain.issue.dtos.UpdateIssue;
import io.jira.domain.issue.exceptions.IssueException;
import io.jira.domain.issue.mappers.IssueMapper;
import io.jira.domain.issue.models.Issue;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import static io.jira.common.utils.MutinyUtils.onUniHandler;

@ApplicationScoped
public class EpicService {

    @Inject
    IssueRepository issueRepository;

    public Uni<Issue> createEpic(CreateIssue createIssue){
        return issueRepository.add(IssueMapper.mapToEpic(createIssue));
    }

    public Uni<Issue> updateEpic(String issueId, UpdateIssue updateIssue) {
        return issueRepository.getById(issueId)
            .flatMap(issue -> onUniHandler(issue, IssueException.EPIC_ENTITY))
            .flatMap(issue -> issueRepository.update(issueId, IssueMapper.mapToEpic(updateIssue)));
    }

}
