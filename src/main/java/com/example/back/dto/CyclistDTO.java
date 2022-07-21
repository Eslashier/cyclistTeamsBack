package com.example.back.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data

public class CyclistDTO {

    private String id;

    @NotEmpty(message = "Competition number is mandatory")
    @NotNull(message = "Competition number is mandatory")
    private String fullName;

    @Positive
    @NotNull(message = "Competition number is mandatory")
    private Integer competitionNumber;

    @NotNull(message = "TeamId is mandatory")
    private String teamId;

    @NotNull(message = "Nationality is mandatory")
    private String nationality;
}
