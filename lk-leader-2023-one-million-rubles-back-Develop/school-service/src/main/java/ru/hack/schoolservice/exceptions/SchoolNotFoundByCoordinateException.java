package ru.hack.schoolservice.exceptions;

public class SchoolNotFoundByCoordinateException extends RuntimeException {
    public SchoolNotFoundByCoordinateException(String schoolId) {
        super("Could school with coordinate" + schoolId);
    }
}
