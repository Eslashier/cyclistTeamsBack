package com.example.back.dto;

import com.example.back.collection.Cyclist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
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
    @Pattern(regexp = "^[A-Za-z0-9]*$")
    @Size(min = 3, message = "Abbreviation must have 3 letters or numbers")
    @Size(max = 3, message = "Abbreviation must have 3 letters or numbers")
    private String teamAbbreviation;

    @NotNull(message = "Country is mandatory")
    private String country;

    @Size(max = 8)
    @DocumentReference
    private List<Cyclist> cyclists;
}
