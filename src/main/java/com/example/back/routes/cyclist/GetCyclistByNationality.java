package com.example.back.routes.cyclist;

import com.example.back.dto.CyclistDTO;
import com.example.back.usecases.cyclist.GetCyclistByNationalityUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

public class GetCyclistByNationality {

    @Bean
    public RouterFunction<ServerResponse> getCyclistByNationality(GetCyclistByNationalityUseCase getCyclistByNationalityUseCase){
        return route(GET("/v1/teamsApi/getCyclistByNationality/{nationality}"),
                request -> ServerResponse
                        .status(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(getCyclistByNationalityUseCase.apply(request.pathVariable("nationality")),
                                CyclistDTO.class))
                );
    }
}
