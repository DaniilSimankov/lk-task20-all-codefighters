package ru.hack.schoolservice.exceptions;

public class SchoolNotFoundByIdException extends RuntimeException {
    public SchoolNotFoundByIdException(String schoolId) {
        super("Could school with id" + schoolId);
    }
}
