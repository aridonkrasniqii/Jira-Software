package io.jira.domain.sprint.dtos;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.List;


public class CreateSprint {
    @NotNull
    @NotBlank
    @NotEmpty
    String name;

    @NotNull
    @NotBlank
    @NotEmpty
    Date startDate;

    @NotNull
    @NotBlank
    @NotEmpty
    Date endDate;

    @NotNull
    @NotBlank
    @NotEmpty
    boolean isActive;

    @NotNull
    @NotBlank
    @NotEmpty
    List<@NotNull String> issuesId;

    public String getName() {
        return name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public boolean isActive() {
        return isActive;
    }

    public List<String> getIssuesId() {
        return issuesId;
    }
}
