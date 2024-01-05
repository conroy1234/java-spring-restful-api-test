package uk.co.huntersix.spring.rest.model;

import java.time.LocalDateTime;

public class PersonExceptionBean {
    LocalDateTime now;
    String message;
    String description;

    public PersonExceptionBean() {
    }

    public PersonExceptionBean(LocalDateTime now, String message, String description) {
        this.now = now;
        this.message = message;
        this.description = description;
    }

    public LocalDateTime getNow() {
        return now;
    }

    public void setNow(LocalDateTime now) {
        this.now = now;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "PersonExceptionBean{" +
                "now=" + now +
                ", message='" + message + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
