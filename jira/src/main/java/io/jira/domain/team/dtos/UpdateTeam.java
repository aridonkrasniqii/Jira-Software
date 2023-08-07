package io.jira.domain.team.dtos;



import io.jira.domain.user.models.UserReference;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;


public class UpdateTeam {
    @NotBlank(message = "Name must not be blank")
    @Size(max = 50, message = "Name must be at most 50 characters")
    private String name;

    @NotBlank(message = "Description must not be blank")
    @Size(max = 100, message = "Description must be at most 100 characters")
    private String description;

    @Valid
    private List<UserReference> members;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<UserReference> getMembers() {
        return members;
    }
}
