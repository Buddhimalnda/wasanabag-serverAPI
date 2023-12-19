package com.wasanabag.serverAPI.repository;

import com.wasanabag.serverAPI.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends MongoRepository<Order, String> {
    List<Optional<Order>> findByDate(String date);
    List<Optional<Order>> findByOrderByCreatedAtDateAsc();
}
