package io.jira.domain.issue.models;

import io.jira.common.models.BaseEntity;
import io.jira.domain.issue.models.enums.LinkedIssueType;

public class LinkedIssue extends BaseEntity {
    public static final String LINKED_ISSUE_TYPE_FIELD = "type";
    public static final String ISSUE_ID_FIELD = "linkedIssues.issue._id";

    private LinkedIssueType type;
    private IssueReference issue;
}
