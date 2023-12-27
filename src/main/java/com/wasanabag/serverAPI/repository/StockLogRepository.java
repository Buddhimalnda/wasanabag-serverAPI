package com.wasanabag.serverAPI.repository;

import com.wasanabag.serverAPI.model.StockLog;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StockLogRepository extends MongoRepository<StockLog, String> {
}
