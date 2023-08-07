package io.jira.domain.issue.dtos;

import io.jira.common.models.NamedEntity;
import io.jira.common.models.enums.IssuePriority;
import io.jira.common.models.enums.IssueType;
import io.jira.domain.issue.models.EpicReference;
import io.jira.domain.issue.models.IssueReference;

import java.util.Date;
import java.util.List;


public class CreateIssue {
    private String name;
    public String summary;
    public Date dueDate;
    public String description;
    public double storyPoint;
    public IssuePriority priority;
    public NamedEntity team;
    public EpicReference epic;
    public NamedEntity project;
    public IssueType type;
    public UserReference creator;
    public UserReference assignee;
    public UserReference reporter;
    public SprintReference sprint;
    public NamedEntity status;
    public IssueReference parentIssue;
    public List<IssueReference> childIssues;


    public String getName() {
        return name;
    }

    public String getSummary() {
        return summary;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public String getDescription() {
        return description;
    }

    public double getStoryPoint() {
        return storyPoint;
    }

    public IssuePriority getPriority() {
        return priority;
    }

    public NamedEntity getTeam() {
        return team;
    }

    public EpicReference getEpic() {
        return epic;
    }

    public NamedEntity getProject() {
        return project;
    }

    public IssueType getType() {
        return type;
    }

    public UserReference getCreator() {
        return creator;
    }

    public UserReference getAssignee() {
        return assignee;
    }

    public UserReference getReporter() {
        return reporter;
    }

    public SprintReference getSprint() {
        return sprint;
    }

    public NamedEntity getStatus() {
        return status;
    }

    public IssueReference getParentIssue() {
        return parentIssue;
    }

    public List<IssueReference> getChildIssues() {
        return childIssues;
    }
}
