package com.wasanabag.serverAPI.model;


import com.wasanabag.serverAPI.types.TimeAt;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "quantity")
public class Quantity {
    @Id
    private String id;
    private String code;
    private int quantity;
    private String unit;
    private TimeAt createdAt;
    private List<TimeAt> updatedAt;
}
