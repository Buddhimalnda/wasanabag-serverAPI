package com.wasanabag.serverAPI.log;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class LoggerService {
    private final LoggerRepository loggerRepository;

    public Logger createLogger(Logger logger) {
        return loggerRepository.save(logger);
    }

    public Logger getLogger(String id) {
        return loggerRepository.findById(id).orElse(null);
    }

    public List<Logger> getAllLogs(HttpServletRequest request) {
        return loggerRepository.findAll();
    }
}
