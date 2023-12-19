package com.wasanabag.serverAPI.repository;

import com.wasanabag.serverAPI.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends MongoRepository<Item, String> {
    List<Optional<Item>> findByName(String name);
}
