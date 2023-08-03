package io.jira.domain.issue.models;

import io.jira.common.models.NamedEntity;

public class EpicReference extends NamedEntity {
    private String summary;
    private String description;
    private int numberOfChildIssues;
}
