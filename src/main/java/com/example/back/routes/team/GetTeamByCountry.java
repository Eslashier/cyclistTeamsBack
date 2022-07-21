package com.example.back.routes.team;

import com.example.back.dto.CyclistDTO;
import com.example.back.dto.TeamDTO;
import com.example.back.usecases.cyclist.GetCyclistByNationalityUseCase;
import com.example.back.usecases.team.GetTeamsByCountryUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GetTeamByCountry {

    @Bean
    public RouterFunction<ServerResponse> getAllTeamsByCountry(GetTeamsByCountryUseCase getTeamsByCountryUseCase){
        return route(GET("/v1/teamsApi/getTeamsByCountry/{country}"), request -> ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(getTeamsByCountryUseCase.findByCountry(request.pathVariable("country")), TeamDTO.class)));

    }
}
