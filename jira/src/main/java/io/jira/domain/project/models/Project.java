package io.jira.domain.project.models;


import io.jira.common.models.BaseEntity;
import io.jira.domain.user.UserReference;

import java.util.List;

public class Project extends BaseEntity {

    private String name;
    private UserReference projectLead;
    private List<UserReference> members;
    private String key;
    private String type;
    private String description;
    private String category;

    public void setName(String name) {
        this.name = name;
    }

    public void setProjectLead(UserReference projectLead) {
        this.projectLead = projectLead;
    }

    public void setMembers(List<UserReference> members) {
        this.members = members;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public UserReference getProjectLead() {
        return projectLead;
    }

    public List<UserReference> getMembers() {
        return members;
    }

    public String getKey() {
        return key;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }
}

