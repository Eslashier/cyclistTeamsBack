package com.example.back.usecases.cyclist;

import com.example.back.collection.Cyclist;
import com.example.back.dto.CyclistDTO;
import com.example.back.mapper.CyclistMapper;
import com.example.back.repository.ICyclistRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@SpringBootTest
class GetAllCyclistsUseCaseTest {

    private GetAllCyclistsUseCase getAllCyclistsUseCase;

    @Autowired
    private CyclistMapper cyclistMapper;

    @Mock
    ICyclistRepository iCyclistRepository;

    @BeforeEach
    void setUp(){
        getAllCyclistsUseCase = new GetAllCyclistsUseCase(iCyclistRepository, cyclistMapper);
    }

    @Test
    void getCyclistsUseCase(){

        Cyclist cyclist = new Cyclist(
                "id1",
                "Name Test",
                50,
                "teamid",
                "Colombian"
        );

        Mockito.when(iCyclistRepository.findAll()).thenReturn(Flux.just(cyclist));
        Flux<CyclistDTO> flux = getAllCyclistsUseCase.getAllCyclists();

        StepVerifier.create(flux)
                .expectNextCount(1)
                .verifyComplete();

        Mockito.verify(iCyclistRepository).findAll();
    }

}