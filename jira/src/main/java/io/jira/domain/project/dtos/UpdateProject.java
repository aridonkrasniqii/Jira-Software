package io.jira.domain.project.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public class UpdateProject {
    @NotEmpty
    @NotBlank
    String name;
    @Valid
    UserReference projectLead;

    List<@Valid UserReference> members;

    @NotEmpty
    @NotBlank
    String key;

    @NotEmpty
    @NotBlank
    String type;

    @NotEmpty
    @NotBlank
    String description;

    @NotEmpty
    @NotBlank
    String category;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserReference getProjectLead() {
        return projectLead;
    }

    public void setProjectLead(UserReference projectLead) {
        this.projectLead = projectLead;
    }

    public List<UserReference> getMembers() {
        return members;
    }

    public void setMembers(List<UserReference> members) {
        this.members = members;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
