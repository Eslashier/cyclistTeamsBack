package com.example.back.usecases.cyclist;

import com.example.back.dto.CyclistDTO;
import com.example.back.mapper.CyclistMapper;
import com.example.back.repository.ICyclistRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@AllArgsConstructor
public class GetCyclistByNationalityUseCase {

    private final ICyclistRepository iCyclistRepository;
    private final CyclistMapper cyclistMapper;

    public Flux<CyclistDTO> findByNationality(String nationality) {
        return iCyclistRepository
                .findByNationality(nationality)
                .map(cyclistMapper::fromCyclistToCyclistDTO);
    }
}
