package io.jira.domain.issue.models;

public class Story extends Issue {
    private EpicReference epic;

    public Story(Issue issue, EpicReference epic) {
        super(issue);
        this.epic = epic;
    }

    public Story(Issue issue) {
        super(issue);
    }

    public EpicReference getEpic() {
        return epic;
    }

    public void setEpic(EpicReference epic) {
        this.epic = epic;
    }
}
