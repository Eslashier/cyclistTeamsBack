package com.example.back.routes.team;

import com.example.back.usecases.team.DeleteTeamUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class DeleteTeamRoute {

    @Bean
    public RouterFunction<ServerResponse> deleteTeamById(DeleteTeamUseCase deleteTeamUseCase){
        return route(DELETE("/v1/teamsApi/deleteCyclist/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> deleteTeamUseCase.deleteTeamById(request.pathVariable("id"))
                        .flatMap(unused -> ServerResponse.status(HttpStatus.ACCEPTED).build())

        );
    }


}
