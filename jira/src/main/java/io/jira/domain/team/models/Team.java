package io.jira.domain.team.models;

import io.jira.common.models.BaseEntity;
import io.jira.domain.user.models.UserReference;

import java.util.List;

public class Team extends BaseEntity {
    public static final String FIELD_MEMBERS = "members";
    public static final String FIELD_MEMBERS_ID = "members._id";
    private String name;
    private String description;
    private List<UserReference> members;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<UserReference> getMembers() {
        return members;
    }

    public void setMembers(List<UserReference> members) {
        this.members = members;
    }
}

