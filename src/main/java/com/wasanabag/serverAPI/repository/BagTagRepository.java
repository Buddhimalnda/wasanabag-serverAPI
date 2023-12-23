package com.wasanabag.serverAPI.repository;

import com.wasanabag.serverAPI.model.BagTag;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BagTagRepository extends MongoRepository<BagTag, String> {
    Optional<BagTag> findByCode(String code);

    Optional<BagTag> findByTag(String tag);
}
