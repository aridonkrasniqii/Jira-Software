package io.jira.domain.issue.models;

public class Subtask extends Issue {
    private EpicReference parentIssue;

    public Subtask(Issue issue, EpicReference parentIssue) {
        super(issue);
        this.parentIssue = parentIssue;
    }

    public Subtask(Issue issue) {
        super(issue);
    }


    public EpicReference getParentIssue() {
        return parentIssue;
    }

    public void setParentIssue(EpicReference parentIssue) {
        this.parentIssue = parentIssue;
    }
}
