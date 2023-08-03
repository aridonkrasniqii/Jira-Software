package io.jira.domain.issue.models;

public class Task extends Issue {
    private EpicReference parentIssue;

    public Task(Issue issue, EpicReference parentIssue) {
        super(issue);
        this.parentIssue = parentIssue;
    }

    public Task(Issue issue) {
        super(issue);
    }


    public EpicReference getParentIssue() {
        return parentIssue;
    }

    public void setParentIssue(EpicReference parentIssue) {
        this.parentIssue = parentIssue;
    }
}
