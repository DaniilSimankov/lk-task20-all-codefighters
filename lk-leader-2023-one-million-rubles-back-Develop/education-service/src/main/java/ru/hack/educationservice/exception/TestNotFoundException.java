package ru.hack.educationservice.exception;

public class TestNotFoundException extends RuntimeException{
    public TestNotFoundException(String id){
        super("Could test with id " + id);
    }
}
