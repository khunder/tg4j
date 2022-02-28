package org.tg4j.tg4jcore.configuration;


import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ErrorDetails {
    private final Date timestamp;
    private final String message;
    private final String details;
    private Object data;

    public ErrorDetails(Date timestamp, String message, String details) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public ErrorDetails(Date timestamp, String message, String details, Object data) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
        this.data = data;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }

    public Object getData() {
        return data;
    }
}
