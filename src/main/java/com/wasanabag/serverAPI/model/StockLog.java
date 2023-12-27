package com.wasanabag.serverAPI.model;

import com.wasanabag.serverAPI.types.StockStatus;
import com.wasanabag.serverAPI.types.StockType;
import com.wasanabag.serverAPI.types.TimeAt;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "stockLog")
public class StockLog {
    private String id;
    private String itemId;
    private String description;
    private StockType type;
    private StockStatus status;
    private TimeAt createAt;
    private List<TimeAt> updatedAt;
    private boolean isSuppler;
    private String supplerId;

    private String ifSupplerAvl(String supplerId){
        if(isSuppler){
            return supplerId;
        }
        return null;
    }


}
