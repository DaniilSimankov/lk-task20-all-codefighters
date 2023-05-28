package ru.lk.task20.newsservice.exception;

public class RubricNotFoundException extends RuntimeException {
    public RubricNotFoundException(String abbr) {
        super("Could rubric news with abbr " + abbr);
    }
}
