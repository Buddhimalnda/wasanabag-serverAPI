package com.wasanabag.serverAPI.repository;

import com.wasanabag.serverAPI.model.StockLog;
import com.wasanabag.serverAPI.types.StockType;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface StockLogRepository extends MongoRepository<StockLog, String> {
    Optional<StockLog> findByItemId(String id);

    List<StockLog> findByType(StockType type);
    List<StockLog> findByCreateAt_Date(String createAt_date);


}
