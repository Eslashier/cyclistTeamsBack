package com.example.back.dto;

import com.example.back.collection.Cyclist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamDTO {

    private String id;

    @NotNull(message = "Team name is mandatory")
    private String teamName;
    @NotNull(message = "Team Abbreviation is mandatory")
    @Size(min = 3, message = "{validation.teamAbbreviation.size.too_short}")
    @Size(max = 3, message = "{validation.teamAbbreviation.size.too_long}")
    private String teamAbbreviation;
    @NotNull(message = "Country is mandatory")
    private String country;
    @Size(max = 8)
    private List<Cyclist> cyclists;
}
