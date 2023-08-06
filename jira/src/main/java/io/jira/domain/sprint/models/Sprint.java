package io.jira.domain.sprint.models;

import io.jira.common.models.BaseEntity;
import io.jira.domain.issue.models.IssueReference;

import java.util.Date;
import java.util.List;

public class Sprint extends BaseEntity {
    public static final String FIELD_ISSUES_ID = "issue._id";
    private String name;
    private Date startDate;
    private Date endDate;
    private boolean isActive;
    private List<String> issuesId;
    private List<IssueReference> issues;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public List<String> getIssuesId() {
        return issuesId;
    }

    public void setIssuesId(List<String> issuesId) {
        this.issuesId = issuesId;
    }

    public List<IssueReference> getIssues() {
        return issues;
    }

    public void setIssues(List<IssueReference> issues) {
        this.issues = issues;
    }
}
