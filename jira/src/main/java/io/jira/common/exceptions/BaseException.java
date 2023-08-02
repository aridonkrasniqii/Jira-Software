package io.jira.common.exceptions;

import io.jira.common.utils.LanguageUtils;

import java.util.Locale;

import static io.jira.common.utils.Utils.isBlank;
import static jakarta.ws.rs.core.Response.Status;

/**
 * @author teknikashi
 */
public class BaseException extends Exception {
//    @JsonbTransient
    public String messageKey;

    private String message;

    private String error_code;
    private Status status;

    private String[] args;

    private Throwable throwable;

    public BaseException() {
        this.error_code = this.getClass().getSimpleName();
    }

    public BaseException(Status status) {
        this();
        this.status = status;
    }

    public BaseException(Status status, String messageKey) {
        this(status);
        this.messageKey = messageKey;
    }

    public BaseException(Status status, String messageKey, String ...args){
        this(status, messageKey);
        this.args = args;
    }


    @Override
    public String getMessage() {
        return message;
    }

    public String[] getArgs() {
        return args;
    }

    public String getMessageKey() {
        return messageKey;
    }


    public Status getStatus() {
        return status;
    }


    public String getError_code() {
        return error_code;
    }

    public BaseException withMessage(String message) {
        this.message = message;
        return this;
    }

    public BaseException withErrorCode(String errorCode) {
        this.error_code = errorCode;
        return this;
    }

    public BaseException withStatus(Status status) {
        this.status = status;
        return this;
    }

    public String getMessageWithLanguage(Locale locale) {
        if(isBlank(this.messageKey)) {
            return message;
        }

        return LanguageUtils.getLocaleMessage(this.messageKey, locale, this.args);
    }
}
