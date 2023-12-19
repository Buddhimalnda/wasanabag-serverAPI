package com.wasanabag.serverAPI.repository;


import com.wasanabag.serverAPI.model.Quantity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface QuantityRepository extends MongoRepository<Quantity, String> {
    Optional<Quantity> findByCode(String code);
}
