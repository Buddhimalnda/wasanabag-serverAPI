package com.wasanabag.serverAPI.servicer;

import com.wasanabag.serverAPI.model.StockLog;
import com.wasanabag.serverAPI.repository.StockLogRepository;
import com.wasanabag.serverAPI.types.StockType;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class StockLogService {
    private StockLogRepository stockLogRepository;

    public List<StockLog> getAllStockLogs() {
        return stockLogRepository.findAll();
    }

    public StockLog createStockLog(StockLog stockLog) {
        return stockLogRepository.save(stockLog);
    }

    public StockLog updateStockLog(StockLog stockLog) {
        StockLog existingStockLog = stockLogRepository.findById(stockLog.getId()).orElse(null);
        existingStockLog.setItemId(stockLog.getItemId());
        existingStockLog.setDescription(stockLog.getDescription());
        existingStockLog.setType(stockLog.getType());
        existingStockLog.setStatus(stockLog.getStatus());
        existingStockLog.setCreateAt(stockLog.getCreateAt());
        existingStockLog.setUpdatedAt(stockLog.getUpdatedAt());
        existingStockLog.setSupplerId(stockLog.getSupplerId());
        existingStockLog.setSuppler(stockLog.isSuppler());
        return stockLogRepository.save(existingStockLog);
    }

    public String deleteStockLog(String id) {
        stockLogRepository.deleteById(id);
        return "StockLog removed !! " + id;
    }

    public StockLog getStockLog(String id) {
        return stockLogRepository.findById(id).orElse(null);
    }

    public Optional<StockLog> getStockLogByItem(String id) {
        return stockLogRepository.findByItemId(id);
    }

    public List<StockLog> getStockLogByType(StockType type) {
        return stockLogRepository.findByType(type);
    }

    public List<StockLog> getLatestStockLog() throws ParseException {
        List<StockLog> list =  stockLogRepository.findAll();
        List<StockLog> latest = null;
        Date current = new Date();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -3);
        Date before = cal.getTime();
        return findByDate(before, list);

    }

    public List<StockLog> getStockLogByDate(String d) throws ParseException {
        Date date = new SimpleDateFormat("E MMM DD yyyy").parse(d);
        List<StockLog> list =  stockLogRepository.findByCreateAt_Date(d);
        return findByDate(date, list);
    }

    private List<StockLog> findByDate(Date date, List<StockLog> list) throws ParseException {
        List<StockLog> latest = null;
        int i = 0;
        while (list.iterator().hasNext()){
            Date date1=new SimpleDateFormat("E MMM DD yyyy").parse(list.get(i).getCreateAt().getDate());
            if(date1.compareTo(date) >= 0){
                latest.add(list.get(i)) ;
            }
            i++;//Fri Dec 22 2023
        }
        return latest;
    }
}