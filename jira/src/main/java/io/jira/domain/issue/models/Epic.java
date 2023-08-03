package io.jira.domain.issue.models;

import java.util.List;

public class Epic extends Issue {
    public List<IssueReference> childIssues;

    public Epic(Issue issue, List<IssueReference> childIssues) {
        super(issue);
        this.childIssues = childIssues;
    }

    public Epic(Issue issue) {
        super(issue);
    }

    public void setChildIssues(List<IssueReference> childIssues) {
        this.childIssues = childIssues;
    }
}
