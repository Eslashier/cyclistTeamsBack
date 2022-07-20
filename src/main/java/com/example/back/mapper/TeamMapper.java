package com.example.back.mapper;

import com.example.back.collection.Team;
import com.example.back.dto.TeamDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.config.EnableWebFlux;

@Component
@EnableWebFlux
public class TeamMapper {

    private final ModelMapper modelMapper;

    public TeamMapper(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    public TeamDTO fromProductToProductDTO(Team team){
        return modelMapper.map(team, TeamDTO.class);
    }

    public Team fromProductDTOToProduct(TeamDTO teamDTO){
        return modelMapper.map(teamDTO, Team.class);
    }

}
