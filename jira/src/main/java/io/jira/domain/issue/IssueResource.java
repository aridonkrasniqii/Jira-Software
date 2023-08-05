package io.jira.domain.issue;

import io.jira.common.models.PaginatedEntity;
import io.jira.common.models.PaginationModel;
import io.jira.domain.issue.dtos.*;
import io.jira.domain.issue.models.Issue;
import io.jira.domain.issue.models.LinkedIssue;
import io.jira.domain.issue.wrappers.IssueFilter;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;


@Path("/issues")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class IssueResource {

    @Inject
    IssueService issueService;

    @POST
    public Uni<Issue> add(CreateIssue createIssue) {
        return issueService.add(createIssue);
    }

    @GET
    public Uni<PaginatedEntity<Issue>> getAll(@BeanParam PaginationModel paginationModel, @BeanParam IssueFilter issueFilter) {
        return issueService.getAll(paginationModel, issueFilter);
    }

    @GET
    @Path("/{issueId}")
    public Uni<Issue> getById(@PathParam("issueId") String issueId) {
        return issueService.getById(issueId);
    }

    @PUT
    @Path("/{issueId}")
    public Uni<Issue> update(@PathParam("issueId") String issueId, UpdateIssue updateIssue) {
        return issueService.update(issueId, updateIssue);
    }


    @DELETE
    public Uni<Issue> delete(@PathParam("issueId") String issueId) {
        return issueService.delete(issueId);
    }


    /** SUBTASKS REGION **/
    @POST
    @Path("/{issueId}/subtasks")
    public Uni<Issue> createIssueSubtask(@PathParam("issueId") String issueId, CreateSubtask subtask) {
        return issueService.addSubtask(issueId, subtask);
    }

    @GET
    @Path("/{id}/subtasks")
    public Uni<PaginatedEntity<Issue>> getIssueAllSubtasks(@PathParam("id") String id, @BeanParam PaginationModel paginationModel) {
        return issueService.getAllSubtasks(id, paginationModel);
    }

    @PUT
    @Path("/{id}/subtasks/{subtaskId}")
    public Uni<Issue> updateSubtask(@PathParam("id") String issueId, @PathParam("subtaskId") String subtaskId, UpdateSubtask subtask) {
        return issueService.updateIssueSubtask(issueId, subtaskId, subtask);
    }

    @DELETE
    @Path("/{id}/subtasks/{subtaskId}")
    public Uni<Issue> deleteSubtask(@PathParam("id") String issueId, @PathParam("subtaskId") String subtaskId) {
        return issueService.deleteSubtask(issueId, subtaskId);
    }

    /** ENDREGION **/


    /**
     * LINKED-ISSUES REGION
     **/
    @POST
    @Path("/{id}/linked-issues")
    public Uni<LinkedIssue> addLinkedIssue(@PathParam("id") String issueId, CreateLinkedIssue linkedIssue) {
        return issueService.addLinkedIssue(issueId, linkedIssue);
    }

    @GET
    @Path("/{id}/linked-issues")
//    public Uni<List<LinkedIssue>> getIssueAllLinkedIssues(@PathParam("id") String issueId) {
//        return issueService.getIssueAllLinkedIssues(issueId);
//    }

    @GET
    @Path("/{id}/linked-issues/{linkedIssueId}")
    public Uni<LinkedIssue> getLinkedIssueById(@PathParam("id") String issueId, @PathParam("linkedIssueId") String linkedIssueId) {
        return issueService.getLinkedIssueById(issueId, linkedIssueId);
    }

    @PUT
    @Path("/{id}/linked-issues/{linkedIssueId}")
    public Uni<LinkedIssue> updateLinkedIssue(@PathParam("id") String issueId, @PathParam("linkedIssueId") String linkedIssueId, UpdateLinkedIssue linkedIssue) {
        return issueService.updateLinkedIssue(issueId, linkedIssueId, linkedIssue);
    }

    @DELETE
    @Path("/{id}/linked-issues/{linkedIssueId}")
    public Uni<Issue> deleteLinkedIssue(@PathParam("id") String issueId, @PathParam("linkedIssueId") String linkedIssueId) {
        return issueService.deleteLinkedIssue(issueId, linkedIssueId);
    }

    /** ENDREGION **/



}
