package io.jira.common.mappers;

import io.jira.common.ContextWrapper;
import io.jira.common.utils.LanguageUtils;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class MultiLanguageMapper {

    @Inject
    ContextWrapper contextWrapper;


    public String getLocaleMessage(String messageKey, String ...args){
        return LanguageUtils.getLocaleMessage(messageKey, contextWrapper.getLocale(), args);
    }
}
