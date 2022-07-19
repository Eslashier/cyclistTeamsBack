package com.example.back.dto;

import com.example.back.collection.Cyclist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamDTO {

    private String id;
    private String teamName;
    private String teamAbbreviation;
    private String country;
    private List<Cyclist> cyclists;
}
