package com.example.back.routes.cyclist;

import com.example.back.dto.CyclistDTO;
import com.example.back.usecases.cyclist.GetAllCyclistsUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GetCyclistRoute {

    @Bean
    public RouterFunction<ServerResponse> getAllCyclists(GetAllCyclistsUseCase getAllCyclistsUseCase){
        return route(GET("/v1/teamsApi/getAllCyclists"), request -> ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(getAllCyclistsUseCase.getAllCyclists(), CyclistDTO.class)));

    }
}
