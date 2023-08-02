package io.jira.common.utils;

public class Utils {

    public static boolean notBlank(String value) {
        return value.trim().length() > 0;
    }

    public static boolean isBlank(String value) {
        return notNull(value) && value.trim().length() == 0;
    }

    public static boolean isNull(Object value) {
        return value == null;
    }

    public static boolean notEmpty(String value) {
        return value.length() > 0;
    }

    public static boolean notNull(Object value) {
        return value != null;
    }
}
