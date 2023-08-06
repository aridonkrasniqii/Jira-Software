package io.jira.domain.sprint.mappers;

import io.jira.domain.sprint.dtos.CreateSprint;
import io.jira.domain.sprint.dtos.UpdateSprint;
import io.jira.domain.sprint.models.Sprint;

public class SprintMapper {

    public static Sprint mapToSprint(CreateSprint createSprint) {
        Sprint sprint = new Sprint();
        sprint.setName(createSprint.getName());
        sprint.setStartDate(createSprint.getStartDate());
        sprint.setEndDate(createSprint.getEndDate());
        sprint.setActive(createSprint.isActive());
        sprint.setIssuesId(createSprint.getIssuesId());
        return sprint;
    }

    public static Sprint mapToSprint(UpdateSprint updateSprint) {
        Sprint sprint = new Sprint();
        sprint.setName(updateSprint.getName());
        sprint.setStartDate(updateSprint.getStartDate());
        sprint.setEndDate(updateSprint.getEndDate());
        sprint.setActive(updateSprint.isActive());
        sprint.setIssuesId(updateSprint.getIssuesId());
        return sprint;
    }
}
