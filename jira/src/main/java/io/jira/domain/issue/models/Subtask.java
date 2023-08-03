package io.jira.domain.issue.models;

public class Subtask extends Issue {
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
