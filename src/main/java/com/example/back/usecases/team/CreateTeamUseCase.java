package com.example.back.usecases.team;

import com.example.back.dto.CyclistDTO;
import com.example.back.dto.TeamDTO;
import com.example.back.mapper.CyclistMapper;
import com.example.back.mapper.TeamMapper;
import com.example.back.repository.ICyclistRepository;
import com.example.back.repository.ITeamRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@Service
@Validated
@AllArgsConstructor
public class CreateTeamUseCase {

    private final ITeamRepository iTeamRepository;
    private final TeamMapper teamMapper;

    public Mono<TeamDTO> postTeam(@Valid TeamDTO teamDTO){
        return iTeamRepository
                .save(teamMapper.fromTeamDTOToTeam(teamDTO))
                .map(teamMapper::fromTeamToTeamDTO);
    }
}
