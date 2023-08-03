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
public class ChildIssuesService {

    @Inject
    IssueRepository issueRepository;

    public Uni<Issue> createIssue(CreateIssue createIssue) {
        return issueRepository.getById(createIssue.getEpic().getId())
            .flatMap(epic -> onUniHandler(epic, IssueException.EPIC_ENTITY))
            .flatMap(ignored -> issueRepository.add(IssueMapper.mapToChildIssue(createIssue)));
    }

    public Uni<Issue> createSubtask(CreateIssue createIssue) {
        return issueRepository.getById(createIssue.getParentIssue().getId())
            .flatMap(parentIssue -> onUniHandler(parentIssue, IssueException.PARENT_ENTITY))
            .flatMap(ignored -> issueRepository.add(IssueMapper.mapToSubtask(createIssue)));
    }

    public Uni<Issue> updateIssue(String issueId, UpdateIssue updateIssue) {
        return issueRepository.getById(issueId)
            .flatMap(issue -> onUniHandler(issue, IssueException.CHILD_ISSUE_ENTITY))
            .flatMap(ignored -> issueRepository.getById(updateIssue.getEpic().getId()))
            .flatMap(parentIssue -> onUniHandler(parentIssue, IssueException.PARENT_ENTITY))
            .flatMap(ignored -> issueRepository.update(issueId, IssueMapper.mapToChildIssue(updateIssue)));
    }

    public Uni<Issue> updateSubtask(String issueId, UpdateIssue updateIssue) {
        return issueRepository.getById(issueId)
            .flatMap(subtask -> onUniHandler(subtask, IssueException.SUBTASK_ENTITY))
            .flatMap(ignored -> issueRepository.update(issueId, IssueMapper.mapToSubtask(updateIssue)));
    }
}
