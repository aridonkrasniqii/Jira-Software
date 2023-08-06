package io.jira.domain.confluencepage.models;

import io.jira.common.models.NamedEntity;

import java.util.List;

public class ConfluencePage {
    public static final String ID_FIELD = "_id";
    public static final String ISSUE_ID_FIELD = "issue._id";
    private List<String> space;
    private String link;
    private NamedEntity issue;
}
