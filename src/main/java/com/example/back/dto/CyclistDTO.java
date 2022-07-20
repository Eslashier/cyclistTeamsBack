package com.example.back.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class CyclistDTO {

    private String id;
    @NotNull(message = "Competition number is mandatory")
    private String fullName;
    @Positive
    @Indexed(unique = true)
    @NotNull(message = "Competition number is mandatory")
    private Integer competitionNumber;
    @NotNull(message = "Team is mandatory")
    private String team;
    @NotNull(message = "Nationality is mandatory")
    private String nationality;
}
