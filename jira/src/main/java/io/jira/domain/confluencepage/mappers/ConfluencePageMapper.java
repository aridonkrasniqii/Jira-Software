package io.jira.domain.confluencepage.mappers;

import io.jira.domain.confluencepage.dtos.CreateConfluencePage;
import io.jira.domain.confluencepage.dtos.UpdateConfluencePage;
import io.jira.domain.confluencepage.models.ConfluencePage;

public class ConfluencePageMapper {




    public static ConfluencePage mapToConfluencePage(CreateConfluencePage createConfluencePage) {
        return new ConfluencePage();
    }

    public static ConfluencePage mapToConfluencePage(UpdateConfluencePage updateConfluencePage ) {
        return new ConfluencePage();
    }
}
