package com.example.back.usecases.cyclist;

import com.example.back.dto.CyclistDTO;
import com.example.back.mapper.CyclistMapper;
import com.example.back.repository.ICyclistRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class CreateCyclistUseCase {

    private final ICyclistRepository iCyclistRepository;
    private final CyclistMapper cyclistMapper;

    public Mono<CyclistDTO> postCyclist(CyclistDTO cyclistDTO){
        return iCyclistRepository
                .save(cyclistMapper.fromCyclistDTOToCyclist(cyclistDTO))
                .map(cyclistMapper::fromCyclistToCyclistDTO);
    }
}
