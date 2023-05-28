package ru.hack.schoolservice.exceptions;

import lombok.NonNull;

public class ArtDirectionNotFoundException extends RuntimeException  {
    public ArtDirectionNotFoundException(@NonNull String name){
        super("Could artDirection with name " + name);
    }
}
