package io.jira.domain.comments.dtos;

import io.jira.common.models.NamedEntity;
import io.jira.domain.user.models.UserReference;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public class CreateComment {
    @Valid
    NamedEntity issue;

    @Valid
    UserReference author;

    @NotBlank
    @NotEmpty
    String textBody;

    public NamedEntity getIssue() {
        return issue;
    }

    public UserReference getAuthor() {
        return author;
    }

    public String getTextBody() {
        return textBody;
    }
}
