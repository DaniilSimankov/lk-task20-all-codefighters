package ru.lk.task20.newsservice.userservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "users")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class User {
    @Id
    private String id;
    private String firstName;
    private String secondName;
    //CAN BE NULL
    private String age;
    private String photoUrl;
    private String email;
    private String phone;
    private String typeOfReg;
    private String VKAuthAccessToken;
    private List<String> priorityList;
    private List<String> mineAchievementsIds;
    private int xp;
    private int lvl;
    private int xpForNextLvl;
    private int coins;
    private List<String> boughtCoursesIds;
    private List<String> friendsIds;
}
