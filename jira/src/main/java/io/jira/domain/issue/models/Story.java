package io.jira.domain.issue.models;

public class Story extends Issue {
    private EpicReference parentIssue;

    public Story(Issue issue, EpicReference parentIssue) {
        super(issue);
        this.parentIssue = parentIssue;
    }

    public Story(Issue issue) {
        super(issue);
    }

    public EpicReference getParentIssue() {
        return parentIssue;
    }

    public void setParentIssue(EpicReference parentIssue) {
        this.parentIssue = parentIssue;
    }
}
