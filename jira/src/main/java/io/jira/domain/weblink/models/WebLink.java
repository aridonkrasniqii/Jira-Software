package io.jira.domain.weblink.models;

import io.jira.common.models.BaseEntity;
import io.jira.common.models.NamedEntity;

public class WebLink extends BaseEntity {
    public static final String FIELD_ISSUE_ID = "issue._id";

    private String url;
    private String linkText;
    private NamedEntity issue;


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLinkText() {
        return linkText;
    }

    public void setLinkText(String linkText) {
        this.linkText = linkText;
    }

    public NamedEntity getIssue() {
        return issue;
    }

    public void setIssue(NamedEntity issue) {
        this.issue = issue;
    }
}