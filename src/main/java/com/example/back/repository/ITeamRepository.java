package com.example.back.repository;

import com.example.back.collection.Team;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITeamRepository extends ReactiveMongoRepository<Team, String> {
}