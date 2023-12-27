package com.wasanabag.serverAPI.servicer;

import com.wasanabag.serverAPI.model.StockLog;
import com.wasanabag.serverAPI.repository.StockLogRepository;

import java.util.List;

public class StockLogService {
    private StockLogRepository stockLogRepository;

    public List<StockLog> getAllStockLogs() {
        return stockLogRepository.findAll();
    }

    public StockLog createStockLog(StockLog stockLog) {
        return stockLogRepository.save(stockLog);
    }
}