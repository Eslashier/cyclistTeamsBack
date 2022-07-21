package com.example.back.routes.cyclist;

import com.example.back.dto.CyclistDTO;
import com.example.back.usecases.cyclist.CreateCyclistUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class PostCyclistRoute {

    @Bean
    public RouterFunction<ServerResponse> createCyclist(CreateCyclistUseCase createCyclistUseCase){
        return route(POST("/v1/teamsApi/createCyclists").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(CyclistDTO.class)
                        .flatMap(createCyclistUseCase::postCyclist)
                        .flatMap(cyclistDTO -> ServerResponse.status(HttpStatus.CREATED)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(cyclistDTO))
        );
    }

}
