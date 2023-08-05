package io.jira.domain.issue.models;

import io.jira.common.models.NamedEntity;
import io.jira.common.models.enums.IssuePriority;
import io.jira.common.models.enums.IssueType;
import io.jira.domain.confluencepage.models.ConfluencePage;
import io.jira.domain.fileattachment.FileAttachment;
import io.jira.domain.sprint.SprintReference;
import io.jira.domain.user.UserReference;
import io.jira.domain.weblink.WebLink;

import java.util.Date;
import java.util.List;

public class Issue {

    public static final String ID_FIELD = "_id";
    public static final String NAME_FIELD = "name";
    public static final String SUMMARY_FIELD = "summary";
    public static final String TYPE_FIELD = "type";
    public static final String DESCRIPTION_FIELD = "description";
    public static final String PRIORITY_FIELD = "priority";
    public static final String SPRINT_ID_FIELD = "sprint._id";
    public static final String REPORTER_ID_FIELD = "reporter._id";
    public static final String ASSIGNEE_FIELD = "assignee";
    public static final String ASSIGNEE_ID_FIELD = "assignee._id";
    public static final String STATUS_ID_FIELD = "status._id";
    public static final String LINKED_ISSUES_FIELD = "linkedIssues";
    public static final String LINKED_ISSUES_ID_FIELD = "linkedIssues._id";
    public static final String WEBLINKS_FIELD = "weblinks";
    public static final String WEBLINKS_ID_FIELD = "weblinks._id";
    public static final String ATTACHED_FILES_FIELD = "attacheFiles";
    public static final String ATTACHED_FILES_ID_FIELD = "attacheFiles._id";
    public static final String CONFLUENCE_PAGES_FIELD = "confluencePages";
    public static final String CONFLUENCE_PAGES_ID_FIELD = "confluencePages._id";
    public static final String SUBTASKS_FIELD = "subtasks";
    public static final String SUBTASKS_ID_FIELD = "subtasks._id";
    public static final String COMMENTS_FIELD = "comments";
    public static final String PROJECT_ID_FIELD = "project._id";
    public static final String EPIC_ID_FIELD = "epic._id";
    public static final String TEAM_ID_FIELD = "team._id";
    public static final String FIELD_SEARCH = "summary";
    public static final String EPIC_NAME_FIELD = "epic._name";


    private String name;
    private String summary;
    private Date dueDate;
    private String description;
    private double storyPoint;
    private IssuePriority priority;
    private NamedEntity team;
    private NamedEntity project;
    private IssueType type;
    private UserReference creator;
    private UserReference assignee;
    private UserReference reporter;
    private SprintReference sprint;
    private NamedEntity status;
    private List<LinkedIssue> linkedIssues;
    private List<ConfluencePage> confluencePages;
    private List<WebLink> webLinks;
    private List<IssueReference> subtasks;
    public List<FileAttachment> attachedFiles;


    public Issue(Issue issue) {
        this.summary = issue.getSummary();
        this.dueDate = issue.getDueDate();
        this.description = issue.getDescription();
        this.storyPoint = issue.getStoryPoint();
        this.priority = issue.getPriority();
        this.team = issue.getTeam();
        this.project = issue.getProject();
        this.type = issue.getType();
        this.creator = issue.getCreator();
        this.assignee = issue.getAssignee();
        this.reporter = issue.getReporter();
        this.sprint = issue.getSprint();
        this.status = issue.getStatus();
        this.linkedIssues = issue.getLinkedIssues();
        this.confluencePages = issue.getConfluencePages();
        this.webLinks = issue.getWebLinks();
        this.subtasks = issue.getSubtasks();
        this.attachedFiles = issue.getAttachedFiles();
    }

    public Issue() {

    }

    public String getName() {
        return name;
    }

    public String getSummary() {
        return summary;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public String getDescription() {
        return description;
    }

    public double getStoryPoint() {
        return storyPoint;
    }

    public IssuePriority getPriority() {
        return priority;
    }

    public NamedEntity getTeam() {
        return team;
    }

    public NamedEntity getProject() {
        return project;
    }

    public IssueType getType() {
        return type;
    }

    public UserReference getCreator() {
        return creator;
    }

    public UserReference getAssignee() {
        return assignee;
    }

    public UserReference getReporter() {
        return reporter;
    }

    public SprintReference getSprint() {
        return sprint;
    }

    public NamedEntity getStatus() {
        return status;
    }

    public List<LinkedIssue> getLinkedIssues() {
        return linkedIssues;
    }

    public List<ConfluencePage> getConfluencePages() {
        return confluencePages;
    }

    public List<WebLink> getWebLinks() {
        return webLinks;
    }

    public List<IssueReference> getSubtasks() {
        return subtasks;
    }

    public List<FileAttachment> getAttachedFiles() {
        return attachedFiles;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStoryPoint(double storyPoint) {
        this.storyPoint = storyPoint;
    }

    public void setPriority(IssuePriority priority) {
        this.priority = priority;
    }

    public void setTeam(NamedEntity team) {
        this.team = team;
    }

    public void setProject(NamedEntity project) {
        this.project = project;
    }

    public void setType(IssueType type) {
        this.type = type;
    }

    public void setCreator(UserReference creator) {
        this.creator = creator;
    }

    public void setAssignee(UserReference assignee) {
        this.assignee = assignee;
    }

    public void setReporter(UserReference reporter) {
        this.reporter = reporter;
    }

    public void setSprint(SprintReference sprint) {
        this.sprint = sprint;
    }

    public void setStatus(NamedEntity status) {
        this.status = status;
    }

    public void setLinkedIssues(List<LinkedIssue> linkedIssues) {
        this.linkedIssues = linkedIssues;
    }

    public void setConfluencePages(List<ConfluencePage> confluencePages) {
        this.confluencePages = confluencePages;
    }

    public void setWebLinks(List<WebLink> webLinks) {
        this.webLinks = webLinks;
    }

    public void setSubtasks(List<IssueReference> subtasks) {
        this.subtasks = subtasks;
    }

    public void setAttachedFiles(List<FileAttachment> attachedFiles) {
        this.attachedFiles = attachedFiles;
    }
}

