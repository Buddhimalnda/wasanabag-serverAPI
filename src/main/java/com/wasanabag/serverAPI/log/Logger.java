package com.wasanabag.serverAPI.log;

import com.wasanabag.serverAPI.types.StatusForLogger;
import com.wasanabag.serverAPI.types.TimeAt;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document(collection = "logs")
@RequiredArgsConstructor
public class Logger {
    @Id
    private String id;
    private String userId;
    private String description;
    private String action;
    private StatusForLogger status;
    private TimeAt createdAt;
    private TimeAt updatedAt;

    public Logger(String userId, String description, String action, StatusForLogger status, TimeAt createdAt, TimeAt updatedAt) {
        this.userId = userId;
        this.description = description;
        this.action = action;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

}
