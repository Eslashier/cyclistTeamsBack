package com.example.back.usecases.cyclist;

import com.example.back.dto.CyclistDTO;
import com.example.back.mapper.CyclistMapper;
import com.example.back.repository.ICyclistRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@AllArgsConstructor
public class GetCyclistByTeamIdUseCase {

    private final ICyclistRepository iCyclistRepository;
    private final CyclistMapper cyclistMapper;

    public Flux<CyclistDTO> findByTeamId(String teamId) {
        return iCyclistRepository
                .findByTeamId(teamId)
                .map(cyclistMapper::fromCyclistToCyclistDTO);
    }
}
