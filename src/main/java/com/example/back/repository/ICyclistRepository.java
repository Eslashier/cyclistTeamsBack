package com.example.back.repository;


import com.example.back.collection.Cyclist;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ICyclistRepository extends ReactiveMongoRepository<Cyclist, String> {

    Flux<Cyclist> findByNationality (String id);

}
