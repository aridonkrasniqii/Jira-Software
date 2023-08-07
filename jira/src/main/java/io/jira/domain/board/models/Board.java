package io.jira.domain.board.models;

import io.kodelabs.jira.common.models.BaseEntity;
import io.kodelabs.jira.common.models.NamedEntity;
import io.kodelabs.jira.domain.user.dtos.UserReference;
import lombok.Data;

@Data
public class Board extends BaseEntity {
    private String name;
    private UserReference admin;
    private NamedEntity project;
}
