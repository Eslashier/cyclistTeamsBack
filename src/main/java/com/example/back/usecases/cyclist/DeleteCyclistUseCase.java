package com.example.back.usecases.cyclist;

import com.example.back.repository.ICyclistRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class DeleteCyclistUseCase {

    private final ICyclistRepository iCyclistRepository;

    public Mono<Void> deleteCyclistById(String id){
        return iCyclistRepository.deleteById(id);
    }
}
