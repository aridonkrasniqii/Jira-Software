package io.jira.domain.user.models;


import io.jira.common.models.NamedEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;



public class UserReference extends NamedEntity {
    @NotBlank(message = "Position is required")
    @Size(max = 50, message = "Position must be a maximum of 50 characters")
    private String position;

    public String getPosition() {
        return position;
    }
}

