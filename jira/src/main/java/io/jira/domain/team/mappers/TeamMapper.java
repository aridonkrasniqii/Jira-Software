package io.jira.domain.team.mappers;

import io.jira.domain.team.dtos.CreateTeam;
import io.jira.domain.team.dtos.UpdateTeam;
import io.jira.domain.team.models.Team;

public class TeamMapper {

    public static Team mapToTeam(CreateTeam createTeam) {
        Team team = new Team();
        team.setName(createTeam.getName());
        team.setDescription(createTeam.getDescription());
        System.out.println(createTeam.getMembers());
        team.setMembers(createTeam.getMembers());

        return team;
    }

    public static Team mapToTeam(UpdateTeam updateTeam) {
        Team team = new Team();
        team.setName(updateTeam.getName());
        team.setDescription(updateTeam.getDescription());
        team.setMembers(updateTeam.getMembers());
        return team;
    }
}
