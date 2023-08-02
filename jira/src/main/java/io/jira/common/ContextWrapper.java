package io.jira.common;

import jakarta.enterprise.context.RequestScoped;

import java.util.Locale;

@RequestScoped
public class ContextWrapper {

    private Locale locale;

    @RequestScoped
    public Locale getLocale() {
        return this.locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

}
