package io.jira.common.utils;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class LanguageUtils {

    private static final String RESOURCE_BUNDLE = "ValidationsMessages";

    public static String getLocaleMessage(String messageKey, Locale locale, String ...args) {
        String errorMessages = getResourceBundle(locale).getString(messageKey);
        return MessageFormat.format(errorMessages, args);
    }


    public static ResourceBundle getResourceBundle(Locale locale) {
        return ResourceBundle.getBundle(RESOURCE_BUNDLE, locale);
    }
}
