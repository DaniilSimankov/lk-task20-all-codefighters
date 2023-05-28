package ru.hack.schoolservice.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "events")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Event {
    @Id
    private String id;

    private String name;
    private String description;
    private String imageUrl;
    private String date;
    private String time;
    private String address;
}
