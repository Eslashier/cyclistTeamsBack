package com.example.back.routes.cyclist;

import com.example.back.dto.CyclistDTO;
import com.example.back.usecases.cyclist.GetCyclistByNationalityUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GetCyclistByNationalityRoute {

    @Bean
    public RouterFunction<ServerResponse> getAllCyclistByNationality(GetCyclistByNationalityUseCase getCyclistByNationalityUseCase){
        return route(GET("/v1/teamsApi/getCyclistByNationality/{nationality}"), request -> ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(getCyclistByNationalityUseCase.findByNationality(request.pathVariable("nationality")), CyclistDTO.class)));

    }
}
