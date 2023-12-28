package com.wasanabag.serverAPI.controller;

import com.wasanabag.serverAPI.model.StockLog;
import com.wasanabag.serverAPI.servicer.StockLogService;
import com.wasanabag.serverAPI.types.StockType;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

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

    @PutMapping("/")
    public StockLog updateStockLog(StockLog stockLog){
        return stockLogService.updateStockLog(stockLog);
    }
    @DeleteMapping("/")
    public String deleteStockLog(String id){
        return stockLogService.deleteStockLog(id);
    }

    @GetMapping("/{id}")
    public StockLog getStockLog(String id){
        return stockLogService.getStockLog(id);
    }

    @GetMapping("/item/{id}")
    public Optional<StockLog> getItemId(String id){
        return stockLogService.getStockLogByItem(id);
    }

    @GetMapping("/type/{type}")
    public List<StockLog> getStockLogByType(StockType type){
        return stockLogService.getStockLogByType(type);
    }

    @GetMapping("/latest")
    public  List<StockLog> getLatestStockLog() throws ParseException {
        return stockLogService.getLatestStockLog();
    }

    @GetMapping("/date")
    public List<StockLog> getStockLogByDate(@RequestBody String date) throws ParseException {
        return stockLogService.getStockLogByDate(date);
    }




}
