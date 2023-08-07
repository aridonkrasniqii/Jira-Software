package io.jira.domain.issue.models;

import io.jira.common.models.NamedEntity;
import io.jira.common.models.enums.IssueType;

public class IssueReference extends NamedEntity {
    private String summary;
    private NamedEntity status;
    private double storyPoints;
    private IssueType type;
    private UserReference assignee;
    private EpicReference epicReference;
}