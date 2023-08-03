package io.jira.domain.issue.mappers;

import io.jira.domain.issue.dtos.CreateIssue;
import io.jira.domain.issue.dtos.UpdateIssue;
import io.jira.domain.issue.models.*;

import static io.jira.common.utils.Utils.notNull;

public class IssueMapper {

    /** CREATE ITEM REGION **/

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

        if(notNull(createIssue.getEpic())) {
            story.setEpic(createIssue.getEpic());
        }

        return story;
    }


    public static Task mapToTask(CreateIssue createIssue) {
        Task task = new Task(mapToIssue(createIssue));

        if(notNull(createIssue.getEpic())) {
            task.setEpic(createIssue.getEpic());
        }

        return task;
    }

    public static Bug mapToBug(CreateIssue createIssue) {
        Bug bug = new Bug(mapToIssue(createIssue));

        if(notNull(createIssue.getEpic())) {
            bug.setEpic(createIssue.getEpic());
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


    /** UPDATE ITEM REGION **/

    public static Issue mapToEpic(UpdateIssue updateIssue) {
        Epic epic = new Epic(mapToIssue(updateIssue));

        if(notNull(updateIssue.getChildIssues())) {
            epic.setChildIssues(updateIssue.getChildIssues());
        }

        return epic;
    }


    public static Issue mapToChildIssue(UpdateIssue updateIssue) {
        return switch (updateIssue.getType()) {
            case TASK -> mapToTask(updateIssue);
            case STORY -> mapToStory(updateIssue);
            case BUG -> mapToBug(updateIssue);
            default -> null;
        };
    }


    public static Story mapToStory(UpdateIssue updateIssue) {
        Story story = new Story(mapToIssue(updateIssue));

        if(notNull(updateIssue.getEpic())) {
            story.setEpic(updateIssue.getEpic());
        }

        return story;
    }


    public static Task mapToTask(UpdateIssue updateIssue) {
        Task task = new Task(mapToIssue(updateIssue));

        if(notNull(updateIssue.getEpic())) {
            task.setEpic(updateIssue.getEpic());
        }

        return task;
    }

    public static Bug mapToBug(UpdateIssue updateIssue) {
        Bug bug = new Bug(mapToIssue(updateIssue));

        if(notNull(updateIssue.getEpic())) {
            bug.setEpic(updateIssue.getEpic());
        }

        return bug;
    }

    public static Issue mapToSubtask(UpdateIssue updateIssue) {
        Subtask subtask = new Subtask(mapToIssue(updateIssue));

        if(notNull(updateIssue.getParentIssue())) {
            subtask.setParentIssue(updateIssue.getParentIssue());
        }

        return subtask;
    }


    private static Issue mapToIssue(UpdateIssue updateIssue) {
        Issue issue = new Issue();

        issue.setName(updateIssue.getName());
        issue.setSummary(updateIssue.getSummary());
        issue.setDueDate(updateIssue.getDueDate());
        issue.setDescription(updateIssue.getDescription());
        issue.setStoryPoint(updateIssue.getStoryPoint());
        issue.setPriority(updateIssue.getPriority());
        issue.setTeam(updateIssue.getTeam());
        issue.setProject(updateIssue.getProject());
        issue.setType(updateIssue.getType());
        issue.setCreator(updateIssue.getCreator());
        issue.setAssignee(updateIssue.getAssignee());
        issue.setReporter(updateIssue.getReporter());
        issue.setSprint(updateIssue.getSprint());
        issue.setStatus(updateIssue.getStatus());

        return issue;
    }
}
