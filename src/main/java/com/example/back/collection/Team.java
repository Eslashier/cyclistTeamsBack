package com.example.back.collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "team")
public class Team {

    @Id
    private String id;
    @Indexed(unique = true)
    private String teamName;
    @Indexed(unique = true)
    private String teamAbbreviation;
    private String country;
    @DocumentReference
    private List<Cyclist> cyclists;
}
