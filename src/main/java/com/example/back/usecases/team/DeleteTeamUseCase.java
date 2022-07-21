package com.example.back.usecases.team;

import com.example.back.repository.ITeamRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class DeleteTeamUseCase {

    private final ITeamRepository iTeamRepository;

    public Mono<Void> deleteTeamById(String id){
        return iTeamRepository.deleteById(id);
    }
}
