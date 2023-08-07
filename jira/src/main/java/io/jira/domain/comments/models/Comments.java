package io.jira.domain.comments.models;


import io.jira.common.models.BaseEntity;
import io.jira.common.models.NamedEntity;
import io.jira.domain.user.models.UserReference;

public class Comments extends BaseEntity {
    public static final String FIELD_ISSUE_ID = "issue._id";
    private NamedEntity issue;
    private UserReference author;
    private String textBody;

    public NamedEntity getIssue() {
        return issue;
    }

    public void setIssue(NamedEntity issue) {
        this.issue = issue;
    }

    public UserReference getAuthor() {
        return author;
    }

    public void setAuthor(UserReference author) {
        this.author = author;
    }

    public String getTextBody() {
        return textBody;
    }

    public void setTextBody(String textBody) {
        this.textBody = textBody;
    }
}
