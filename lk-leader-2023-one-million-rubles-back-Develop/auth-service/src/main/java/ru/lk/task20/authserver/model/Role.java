package ru.lk.task20.authserver.model;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Role {
    ADMIN("admin"),
    MODERATOR("moderator"),
    USER("user");

    private String roleName;
}
