package com.example.back.usecases.cyclist;

import com.example.back.collection.Cyclist;
import com.example.back.dto.CyclistDTO;
import com.example.back.repository.ICyclistRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UpdateCyclistUseCaseTest {

    @MockBean
    private UpdateCyclistUseCase updateCyclistUseCase;

    @Mock
    ICyclistRepository iCyclistRepository;

    @Test
    void updateCyclistTest(){
        Cyclist cyclist = new Cyclist(
                "id1",
                "Name Test",
                50,
                "teamid",
                "Colombian"
        );

        CyclistDTO cyclistDTO = new CyclistDTO();
        cyclistDTO.setId(cyclist.getId());
        cyclistDTO.setFullName(cyclist.getFullName());
        cyclistDTO.setCompetitionNumber(cyclist.getCompetitionNumber());
        cyclistDTO.setTeamId(cyclist.getTeamId());
        cyclistDTO.setNationality(cyclist.getNationality());



        StepVerifier.create(Mono.just(Mockito.when(updateCyclistUseCase.putCyclist(cyclistDTO))
                        .thenReturn(Mono.just(cyclistDTO))))
                        .expectComplete();
    }

}