package com.example.back.routes.cyclist;

import com.example.back.dto.CyclistDTO;
import com.example.back.usecases.cyclist.GetCyclistByTeamIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GetCyclistByTeamIdRoute {

    @Bean
    public RouterFunction<ServerResponse> getAllCyclistByTeamId(GetCyclistByTeamIdUseCase getCyclistByTeamIdUseCase){
        return route(GET("/v1/teamsApi/getCyclistByTeamId/{teamId}"), request -> ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(getCyclistByTeamIdUseCase.findByTeamId(request.pathVariable("teamId")), CyclistDTO.class)));

    }
}
