package io.jira.domain.issue;

import io.jira.common.exceptions.ExceptionMessageKey;
import io.jira.common.models.PaginatedEntity;
import io.jira.common.models.PaginationModel;
import io.jira.common.models.enums.IssueType;
import io.jira.domain.confluencepage.models.ConfluencePage;
import io.jira.domain.issue.dtos.*;
import io.jira.domain.issue.exceptions.IssueException;
import io.jira.domain.issue.mappers.IssueMapper;
import io.jira.domain.issue.models.Issue;
import io.jira.domain.issue.models.LinkedIssue;
import io.jira.domain.issue.services.ChildIssuesService;
import io.jira.domain.issue.services.EpicService;
import io.jira.domain.issue.wrappers.IssueFilter;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.core.Response;

import java.util.List;

import static io.jira.common.utils.MutinyUtils.onUniHandler;
import static io.jira.common.utils.Utils.not;

@ApplicationScoped
public class IssueService {

    @Inject
    IssueRepository issueRepository;

    @Inject
    EpicService epicService;

    @Inject
    ChildIssuesService childIssuesService;

    public Uni<Issue> add(CreateIssue createIssue) {
        return processIssueCreate(createIssue);
    }

    public Uni<PaginatedEntity<Issue>> getAll(PaginationModel paginationModel, IssueFilter issueFilter) {
        return issueRepository.getAll(paginationModel, issueFilter);
    }

    public Uni<Issue> getById(String issueId) {
        return issueRepository.getById(issueId)
            .flatMap(issue -> onUniHandler(issue, IssueException.ISSUE_ENTITY));
    }

    public Uni<Issue> update(String issueId, UpdateIssue updateIssue) {
        return processIssueUpdate(issueId, updateIssue);
    }

    public Uni<Issue> delete(String issueId) {
        return issueRepository.delete(issueId)
            .flatMap(issue -> onUniHandler(issue, IssueException.ISSUE_ENTITY));
    }


    public Uni<Issue> processIssueCreate(CreateIssue createIssue) {
        return switch (createIssue.getType()) {
            case EPIC -> epicService.createEpic(createIssue);
            case SUBTASK -> childIssuesService.createSubtask(createIssue);
            default -> childIssuesService.createIssue(createIssue);
        };
    }

    public Uni<Issue> processIssueUpdate(String issueId, UpdateIssue updateIssue) {
        return switch (updateIssue.getType()) {
            case EPIC -> epicService.updateEpic(issueId, updateIssue);
            case SUBTASK -> childIssuesService.updateSubtask(issueId, updateIssue);
            default -> childIssuesService.updateIssue(issueId, updateIssue);
        };
    }

    /** SUBTASK REGION **/
    public Uni<Issue> addSubtask(String issueId, @Valid CreateSubtask createSubtask) {
        return issueRepository.getById(issueId)
            .flatMap(parentIssue -> onUniHandler(parentIssue, IssueException.PARENT_ISSUE_ENTITY))
            .flatMap(parentIssue -> isNotIssue(parentIssue, IssueType.EPIC, IssueType.SUBTASK))
            .flatMap(ignored -> issueRepository.add(IssueMapper.mapToSubtask(createSubtask)))
            .flatMap(ignored -> issueRepository.addSubtaskToIssue(issueId, IssueMapper.mapToIssueReference(createSubtask)));
    }

    public Uni<PaginatedEntity<Issue>> getAllSubtasks(String issueId, PaginationModel paginationModel) {
        return issueRepository.getAllSubtasks(issueId, paginationModel);
    }

    public Uni<Issue> updateIssueSubtask(String issueId, String subtaskId, @Valid UpdateSubtask updateSubtask) {
        return issueRepository.getById(issueId)
            .flatMap(parentIssue -> onUniHandler(parentIssue, IssueException.PARENT_ISSUE_ENTITY))
            .flatMap(ignored -> issueRepository.getById(subtaskId))
            .flatMap(subtask -> onUniHandler(subtask, IssueException.SUBTASK_ENTITY))
            .flatMap(subtask -> isIssue(subtask, IssueType.SUBTASK))
            .flatMap(ignored -> issueRepository.update(subtaskId, IssueMapper.mapToSubtask(updateSubtask)))
            .flatMap(ignored -> issueRepository.updateSubtaskToIssue(issueId, subtaskId, IssueMapper.mapToIssueReference(updateSubtask)));
    }

    public Uni<Issue> deleteSubtask(String issueId, String taskId) {
        return issueRepository.delete(taskId)
            .flatMap(subtask -> onUniHandler(subtask, IssueException.SUBTASK_ENTITY))
            .flatMap(deleted -> issueRepository.deleteSubtaskToIssue(issueId, taskId))
            .onItem().ifNull().failWith(() ->
                new IssueException(ExceptionMessageKey.ENTITY_NOT_DELETED, Response.Status.BAD_REQUEST));
    }

    /** ENDREGION **/

    /** LINKED ISSUE REGION **/
    public Uni<LinkedIssue> addLinkedIssue(String issueId, CreateLinkedIssue createLinkedIssue) {
        LinkedIssue linkedIssue = IssueMapper.mapToLinkedIssue(createLinkedIssue);
        String relatedIssueId = linkedIssue.getIssue().getId();

        return addLinkedIssueToIssue(issueId, linkedIssue)
            .flatMap(created -> addReversedLinkedIssueToIssue(relatedIssueId, created))
            .onItem().ifNull().failWith(() ->
                new IssueException(ExceptionMessageKey.ENTITY_NOT_CREATED, Response.Status.BAD_REQUEST));

    }

    private Uni<LinkedIssue> addLinkedIssueToIssue(String issueId, LinkedIssue linkedIssue) {
        return issueRepository.getById(issueId)
            .flatMap(issue -> onUniHandler(issue, IssueException.ISSUE_ENTITY))
            .flatMap(ignored -> issueRepository.addLinkedIssue(issueId, linkedIssue));
    }

    private Uni<LinkedIssue> addReversedLinkedIssueToIssue(String issueId, LinkedIssue linkedIssue) {
        LinkedIssue reversedLinkedIssue = IssueMapper.reverseLinkedIssue(linkedIssue);

        return addLinkedIssueToIssue(issueId, reversedLinkedIssue);
    }

    public Uni<PaginatedEntity<LinkedIssue>> getAllLinkedIssues(String issueId) {
        return issueRepository.getAllLinkedIssues(issueId);
    }

    public Uni<LinkedIssue> updateLinkedIssue(String issueId, String linkedIssueId, @Valid UpdateLinkedIssue updateLinkedIssue) {
        LinkedIssue linkedIssue = IssueMapper.mapToLinkedIssue(updateLinkedIssue);

        return updateLinkedIssueToIssue(issueId, linkedIssueId, linkedIssue)
            .flatMap(updated -> onUniHandler(updated, IssueException.LINKED_ISSUE_ENTITY))
            .flatMap(ignored -> updateReversedLinkedIssueToIssue(linkedIssueId, issueId, linkedIssue))
            .onItem().ifNull().failWith(() ->
                new IssueException(ExceptionMessageKey.ENTITY_NOT_UPDATED, Response.Status.BAD_REQUEST));
    }


    private Uni<LinkedIssue> updateLinkedIssueToIssue(String issueId, String linkedIssueId, LinkedIssue linkedIssue) {
        return null;
    }

    private Uni<LinkedIssue> updateReversedLinkedIssueToIssue(String issueId, String linkedIssueId, LinkedIssue linkedIssue) {
        return null;
    }

    public Uni<LinkedIssue> deleteLinkedIssue(String issueId, String linkedIssueId) {
        return issueRepository.deleteLinkedIssue(issueId, linkedIssueId)
            .flatMap(deleted -> onUniHandler(deleted, IssueException.LINKED_ISSUE_ENTITY))
            .flatMap(deleted -> issueRepository.deleteLinkedIssue(linkedIssueId, issueId))
            .onItem().ifNull().failWith(() ->
                new IssueException(ExceptionMessageKey.ENTITY_NOT_DELETED, Response.Status.BAD_REQUEST));
    }

    /** ENDREGION **/


    /** CONFLUENCE PAGE REGION **/

    public Uni<ConfluencePage> addConfluencePage(String issueId, CreateConfluencePage createConfluencePage) {
        return null;
    }

    public Uni<PaginatedEntity<ConfluencePage>> getAllConfluencePages(String issueId) {
        return null;
    }


    public Uni<ConfluencePage> updateConfluencePage(String issueId, @Valid UpdateConfluencePage updateConfluencePage) {
        return null;
    }

    public Uni<ConfluencePage> deleteConfluencePage(String issueId, String confluencePageId) {
        return null;
    }

    /** ENDREGION **/

    public Uni<Issue> isNotIssue(Issue issue, IssueType... issueTypes) {
        if (not(List.of(issueTypes).contains(issue.getType()))) {
            return Uni.createFrom().item(issue);
        }

        throw new IssueException(ExceptionMessageKey.INVALID_DTO, Response.Status.BAD_REQUEST);
    }


    public Uni<Issue> isIssue(Issue issue, IssueType issueType) {
        if (issue.getType().equals(issueType)) {
            return Uni.createFrom().item(issue);
        }

        throw new IssueException(ExceptionMessageKey.INVALID_DTO, Response.Status.BAD_REQUEST);
    }

}
