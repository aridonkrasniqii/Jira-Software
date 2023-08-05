package io.jira.domain.issue.exceptions;

import io.jira.common.exceptions.BaseException;
import jakarta.ws.rs.core.Response;

public class IssueException extends BaseException {

    public static final String ISSUE_ENTITY = "Issue Entity";
    public static final String EPIC_ENTITY = "Epic Entity";
    public static final String SUBTASK_ENTITY = "Subtask Entity";
    public static final String STORY_ENTITY = "Story Entity";
    public static final String BUG_ENTITY = "Bug Entity";
    public static final String TASK_ENTITY = "Task Entity";
    public static final String CHILD_ISSUE_ENTITY = "Child Issue Entity";
    public static final String PARENT_ISSUE_ENTITY = "Parent Issue Entity";
    public static final String LINKED_ISSUE_ENTITY = "Linked Issue Entity";

    public IssueException(String messageKey, Response.Status status) {
        super(status, messageKey);
    }

    public IssueException(String messageKey, Response.Status status, String ...args) {
        super(status, messageKey, args);
    }
}
