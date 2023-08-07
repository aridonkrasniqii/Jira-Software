package io.jira.domain.board.dtos;


import io.kodelabs.jira.common.models.NamedEntity;
import io.kodelabs.jira.domain.user.dtos.UserReference;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UpdateBoard {
    @NotBlank(message = "Name is required")
    @Size(max = 100, message = "Name must be a maximum of 100 characters")
    String name;

    @Valid
    UserReference admin;

    @Valid
    NamedEntity project;
}
