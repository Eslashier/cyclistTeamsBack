package com.example.back.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CyclistDTO {

    private String id;
    private String fullName;
    private Integer competitionNumber;
    private String team;
    private String nationality;

}
