package io.jira.domain.issue.models;

public class Task extends Issue {
    private EpicReference epic;

    public Task(Issue issue, EpicReference epic) {
        super(issue);
        this.epic = epic;
    }

    public Task(Issue issue) {
        super(issue);
    }

    public EpicReference getEpic() {
        return epic;
    }

    public void setEpic(EpicReference epic) {
        this.epic = epic;
    }
}
