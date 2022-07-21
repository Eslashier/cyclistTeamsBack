package com.example.back.usecases.team;

import com.example.back.dto.CyclistDTO;
import com.example.back.dto.TeamDTO;
import com.example.back.mapper.TeamMapper;
import com.example.back.repository.ITeamRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@AllArgsConstructor
public class GetTeamsByCountryUseCase {

    private final ITeamRepository iTeamRepository;
    private final TeamMapper teamMapper;

    public Flux<TeamDTO> findByCountry(String country) {
        return iTeamRepository
                .findByCountry(country)
                .map(teamMapper::fromProductToProductDTO);
    }
}