package io.jira.domain.sprint.models;


import io.jira.common.models.NamedEntity;

public class SprintReference extends NamedEntity {
    private String startDate;
    private String endDate;
    private boolean isActive;
}