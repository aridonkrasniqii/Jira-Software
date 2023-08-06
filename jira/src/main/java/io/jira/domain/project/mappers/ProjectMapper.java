package io.jira.domain.project.mappers;

import io.jira.domain.project.dtos.CreateProject;
import io.jira.domain.project.dtos.UpdateProject;
import io.jira.domain.project.models.Project;

public class ProjectMapper {

    public static Project mapToProject(CreateProject createProject) {
        Project project = new Project();

        project.setName(createProject.getName());
        project.setProjectLead(createProject.getProjectLead());
        project.setMembers(createProject.getMembers());
        project.setKey(createProject.getKey());
        project.setDescription(createProject.getDescription());
        project.setCategory(createProject.getCategory());

        return project;
    }

    public static Project mapToProject(UpdateProject updateProject) {
        Project project = new Project();

        project.setName(updateProject.getName());
        project.setProjectLead(updateProject.getProjectLead());
        project.setMembers(updateProject.getMembers());
        project.setKey(updateProject.getKey());
        project.setDescription(updateProject.getDescription());
        project.setCategory(updateProject.getCategory());

        return project;
    }
}
