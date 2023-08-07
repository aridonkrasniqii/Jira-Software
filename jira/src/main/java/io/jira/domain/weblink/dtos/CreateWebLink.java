package io.jira.domain.weblink.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public class CreateWebLink {
    @NotEmpty(message = "URL cannot be empty")
    @NotBlank(message = "Link text cannot be blank")
    @Pattern(regexp = "^(http|https)://.*$", message = "Invalid URL format")
    private String url;

    @NotEmpty(message = "Link text cannot be empty")
    @NotBlank(message = "Link text cannot be blank")
    private String linkText;


    public String getUrl() {
        return url;
    }

    public String getLinkText() {
        return linkText;
    }
}
