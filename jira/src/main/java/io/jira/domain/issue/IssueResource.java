package io.jira.domain.issue;

import io.jira.common.models.PaginatedEntity;
import io.jira.common.models.PaginationModel;
import io.jira.domain.issue.dtos.CreateIssue;
import io.jira.domain.issue.dtos.UpdateIssue;
import io.jira.domain.issue.models.Issue;
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
}
