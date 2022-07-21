package com.example.back.collection;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "cyclist")
public class Cyclist {

    @Id
    private String id;
    private String fullName;
    private Integer competitionNumber;
    private String team;
    private String nationality;
}
