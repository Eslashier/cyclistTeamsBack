package com.example.back.routes.cyclist;

import com.example.back.usecases.cyclist.DeleteCyclistUseCase;
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
public class DeleteCyclistRoute {

    @Bean
    public RouterFunction<ServerResponse> deleteCyclistById(DeleteCyclistUseCase deleteCyclistUseCase){
        return route(DELETE("/v1/teamsApi/deleteCyclist/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> deleteCyclistUseCase.deleteCyclistById(request.pathVariable("id"))
                        .flatMap(unused -> ServerResponse.status(HttpStatus.ACCEPTED).build())

        );
    }
}
