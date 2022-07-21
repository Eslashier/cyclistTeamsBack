package com.example.back.routes.team;

import com.example.back.dto.TeamDTO;
import com.example.back.usecases.team.UpdateTeamUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class PutTeamRoute {

    @Bean
    public RouterFunction<ServerResponse> updateTeam(UpdateTeamUseCase updateTeamUseCase){
        return route(PUT("/v1/teamsApi/updateTeam").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(TeamDTO.class)
                        .flatMap(updateTeamUseCase::putTeam)
                        .flatMap(teamDTO -> ServerResponse.status(HttpStatus.CREATED)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(teamDTO))
        );
    }
}
