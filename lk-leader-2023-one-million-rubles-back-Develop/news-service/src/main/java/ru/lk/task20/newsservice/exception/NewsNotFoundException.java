package ru.lk.task20.newsservice.exception;

public class NewsNotFoundException extends RuntimeException {
    public NewsNotFoundException(String id) {
        super("Could rubric news with id " + id);
    }
}