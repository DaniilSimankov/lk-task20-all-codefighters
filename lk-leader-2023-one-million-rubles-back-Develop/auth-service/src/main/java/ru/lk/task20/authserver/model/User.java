package ru.lk.task20.authserver.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private String id;
    private String firstName;
    private String secondName;
    private String password;
    //CAN BE NULL
    private String age;
    private Role role;
    private String photoUrl;
    private String email;
    private String phone;
    private String typeOfReg;
    private String VKId;
    private List<String> priorityList;
    private List<String> mineAchievementsIds;
    private int xp;
    private int lvl;
    private int xpForNextLvl;
    private int coins;
    private List<String> boughtCoursesIds;
    private List<String> friendsIds;
}
