package com.example.back.collection;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "cyclist")
public class Cyclist {

    @Id
    private String id;
    private String fullName;
    private Integer competitionNumber;
    private String teamId;
    private String nationality;
}
