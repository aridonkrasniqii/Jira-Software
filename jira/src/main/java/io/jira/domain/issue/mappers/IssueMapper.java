package io.jira.domain.issue.mappers;

import io.jira.domain.issue.dtos.CreateIssue;
import io.jira.domain.issue.models.*;

import static io.jira.common.utils.Utils.notNull;

public class IssueMapper {

    public static Issue mapToEpic(CreateIssue createIssue) {
        Epic epic = new Epic(mapToIssue(createIssue));

        if(notNull(createIssue.getChildIssues())) {
            epic.setChildIssues(createIssue.getChildIssues());
        }

        return epic;
    }

    public static Issue mapToChildIssue(CreateIssue createIssue) {
        return switch (createIssue.getType()) {
            case TASK -> mapToTask(createIssue);
            case STORY -> mapToStory(createIssue);
            case BUG -> mapToBug(createIssue);
            default -> null;
        };
    }


    public static Story mapToStory(CreateIssue createIssue) {
        Story story = new Story(mapToIssue(createIssue));

        if(notNull(createIssue.getParentIssue())) {
            story.setParentIssue(createIssue.getParentIssue());
        }

        return story;
    }


    public static Task mapToTask(CreateIssue createIssue) {
        Task task = new Task(mapToIssue(createIssue));

        if(notNull(createIssue.getParentIssue())) {
            task.setParentIssue(createIssue.getParentIssue());
        }

        return task;
    }

    public static Bug mapToBug(CreateIssue createIssue) {
        Bug bug = new Bug(mapToIssue(createIssue));

        if(notNull(createIssue.getParentIssue())) {
            bug.setParentIssue(createIssue.getParentIssue());
        }

        return bug;
    }

    public static Issue mapToSubtask(CreateIssue createIssue) {
        Subtask subtask = new Subtask(mapToIssue(createIssue));

        if(notNull(createIssue.getParentIssue())) {
            subtask.setParentIssue(createIssue.getParentIssue());
        }

        return subtask;
    }



    private static Issue mapToIssue(CreateIssue createIssue) {
        Issue issue = new Issue();

        issue.setName(createIssue.getName());
        issue.setSummary(createIssue.getSummary());
        issue.setDueDate(createIssue.getDueDate());
        issue.setDescription(createIssue.getDescription());
        issue.setStoryPoint(createIssue.getStoryPoint());
        issue.setPriority(createIssue.getPriority());
        issue.setTeam(createIssue.getTeam());
        issue.setProject(createIssue.getProject());
        issue.setType(createIssue.getType());
        issue.setCreator(createIssue.getCreator());
        issue.setAssignee(createIssue.getAssignee());
        issue.setReporter(createIssue.getReporter());
        issue.setSprint(createIssue.getSprint());
        issue.setStatus(createIssue.getStatus());

        return issue;
    }

}
