package com.example.back.mapper;

import com.example.back.collection.Cyclist;
import com.example.back.dto.CyclistDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.config.EnableWebFlux;

import java.util.Optional;

@Component
@EnableWebFlux
public class CyclistMapper {

    private final ModelMapper modelMapper;

    public CyclistMapper(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    public CyclistDTO fromCyclistToCyclistDTO(Cyclist cyclist){
        return modelMapper.map(cyclist, CyclistDTO.class);
    }

    public Cyclist fromCyclistDTOToCyclist(CyclistDTO cyclistDTO){
        return modelMapper.map(cyclistDTO, Cyclist.class);
    }

}
