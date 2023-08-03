package io.jira.domain.issue.models;

public class Bug extends Issue {

    private EpicReference epic;

    public Bug(Issue issue, EpicReference epic) {
        super(issue);
        this.epic = epic;
    }

    public Bug(Issue issue) {
        super(issue);
    }

    public EpicReference getEpic() {
        return epic;
    }

    public void setEpic(EpicReference epic) {
        this.epic = epic;
    }
}
