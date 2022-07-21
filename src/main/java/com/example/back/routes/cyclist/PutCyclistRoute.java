package com.example.back.routes.cyclist;

import com.example.back.dto.CyclistDTO;
import com.example.back.usecases.cyclist.CreateCyclistUseCase;
import com.example.back.usecases.cyclist.UpdateCyclistUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class PutCyclistRoute {

    @Bean
    public RouterFunction<ServerResponse> updateCyclist(UpdateCyclistUseCase updateCyclistUseCase){
        return route(PUT("/v1/teamsApi/updateCyclist").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(CyclistDTO.class)
                        .flatMap(updateCyclistUseCase::putCyclist)
                        .flatMap(cyclistDTO -> ServerResponse.status(HttpStatus.CREATED)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(cyclistDTO))
        );
    }

}
