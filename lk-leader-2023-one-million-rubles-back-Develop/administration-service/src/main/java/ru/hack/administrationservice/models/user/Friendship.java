package ru.hack.administrationservice.models.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "friendships")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Friendship {
    @Id
    private String id;
    private String idFrom;
    private String idTo;
    private Status status;
}
