package com.example.back.repository;


import com.example.back.collection.Cyclist;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICyclistRepository extends ReactiveMongoRepository<Cyclist, String> {
}
