package com.example.back.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CyclistDTO {

    private String id;
    @NotNull(message = "Name is mandatory")
    private String fullName;
    @Positive
    @NotNull(message = "Competition number is mandatory")
    private Integer competitionNumber;
    @NotNull(message = "Team is mandatory")
    private String team;
    @NotNull(message = "Nationality is mandatory")
    private String nationality;

}
