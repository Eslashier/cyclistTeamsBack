package com.example.back.usecases.cyclist;

import com.example.back.dto.CyclistDTO;
import com.example.back.mapper.CyclistMapper;
import com.example.back.repository.ICyclistRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@Service
@Validated
@AllArgsConstructor
public class UpdateCyclistUseCase {

    private final ICyclistRepository iCyclistRepository;
    private final CyclistMapper cyclistMapper;

    public Mono<CyclistDTO> putCyclist(@Valid CyclistDTO cyclistDTO){
        return iCyclistRepository
                .save(cyclistMapper.fromCyclistDTOToCyclist(cyclistDTO))
                .map(cyclistMapper::fromCyclistToCyclistDTO);
    }
}
