package io.jira.domain.issue.models;

public class Bug extends Issue {

    private EpicReference parentIssue;

    public Bug(Issue issue, EpicReference parentIssue) {
        super(issue);
        this.parentIssue = parentIssue;
    }

    public Bug(Issue issue) {
        super(issue);
    }

    public EpicReference getParentIssue() {
        return parentIssue;
    }

    public void setParentIssue(EpicReference parentIssue) {
        this.parentIssue = parentIssue;
    }
}
