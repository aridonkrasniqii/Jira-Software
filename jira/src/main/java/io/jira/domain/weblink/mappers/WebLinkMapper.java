package io.jira.domain.weblink.mappers;

import io.jira.domain.weblink.dtos.CreateWebLink;
import io.jira.domain.weblink.dtos.UpdateWebLink;
import io.jira.domain.weblink.models.WebLink;

public class WebLinkMapper {

    public static WebLink mapToWebLink(CreateWebLink createWeblink) {
        WebLink webLink = new WebLink();
        webLink.setUrl(createWeblink.getUrl());
        webLink.setLinkText(createWeblink.getLinkText());
        return webLink;
    }

    public static WebLink mapToWebLink(UpdateWebLink createWeblink) {
        WebLink webLink = new WebLink();
        webLink.setUrl(createWeblink.getUrl());
        webLink.setLinkText(createWeblink.getLinkText());
        return webLink;
    }
}
