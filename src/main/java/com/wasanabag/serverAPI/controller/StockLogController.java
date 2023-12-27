package com.wasanabag.serverAPI.controller;

import com.wasanabag.serverAPI.model.StockLog;
import com.wasanabag.serverAPI.servicer.StockLogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public class StockLogController {
    private StockLogService stockLogService;

    @GetMapping("/all")
    public List<StockLog> getAllStockLogs(){
        return stockLogService.getAllStockLogs();
    }

    @PostMapping("/create")
    public StockLog createStockLog(StockLog stockLog){
        return stockLogService.createStockLog(stockLog);
    }

}
