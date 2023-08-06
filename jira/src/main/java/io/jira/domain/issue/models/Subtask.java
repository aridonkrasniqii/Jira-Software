package io.jira.domain.issue.models;

import java.util.List;

public class Subtask extends Issue {
    public static final String PARENT_ISSUE_ID_FIELD = "parentIssue._id";
    private IssueReference parentIssue;

    public Subtask(Issue issue, IssueReference parentIssue) {
        super(issue);
        this.parentIssue = parentIssue;
    }

    public Subtask(Issue issue) {
        super(issue);
    }


    public IssueReference getParentIssue() {
        return parentIssue;
    }

    public void setParentIssue(IssueReference parentIssue) {
        this.parentIssue = parentIssue;
    }
}
