package com.wasanabag.serverAPI.log;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface LoggerRepository extends MongoRepository<Logger, String> {

}
