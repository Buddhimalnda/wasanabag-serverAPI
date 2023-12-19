package com.wasanabag.serverAPI.log;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Data
@RestController
@RequestMapping("/api/v1/log")
public class LoggerController {
    private final LoggerService loggerService;

    @GetMapping("/all")
    public List<Logger> getAllLogs(@RequestHeader HttpServletRequest request){
        return loggerService.getAllLogs(request);
    }
}
