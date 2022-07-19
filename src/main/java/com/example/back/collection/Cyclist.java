package com.example.back.collection;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "cyclist")
public class Cyclist {

    @Id
    private String id;
    private String fullName;
    private Integer competitionNumber;
    private String team;
    private String nationality;
}
