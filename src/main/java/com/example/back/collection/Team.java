package com.example.back.collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "team")
public class Team {

    @Id
    private String id;
    private String teamName;
    private String teamAbbreviation;
    private String country;
    private List<Cyclist> cyclists;
}
