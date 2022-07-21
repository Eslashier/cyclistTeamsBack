package com.example.back.routes.team;

import com.example.back.dto.CyclistDTO;
import com.example.back.dto.TeamDTO;
import com.example.back.usecases.cyclist.CreateCyclistUseCase;
import com.example.back.usecases.team.CreateTeamUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class PostTeamRoute {

    @Bean
    public RouterFunction<ServerResponse> createTEam(CreateTeamUseCase createTeamUseCase){
        return route(POST("/v1/teamsApi/createTeam").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(TeamDTO.class)
                        .flatMap(createTeamUseCase::postTeam)
                        .flatMap(teamDTO -> ServerResponse.status(HttpStatus.CREATED)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(teamDTO))
        );
    }
}
