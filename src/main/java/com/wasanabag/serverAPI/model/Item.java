package com.wasanabag.serverAPI.model;


import com.wasanabag.serverAPI.types.ItemCategory;
import com.wasanabag.serverAPI.types.ItemSize;
import com.wasanabag.serverAPI.types.TimeAt;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "item")
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    @Id
    private String id;
    private String name;
    private String description;
    private ItemCategory category;
    private String[] image;
    private String[] tags;
    private Integer price;
    private ItemSize size;
    private String color;
    private TimeAt createdAt;
    private List<TimeAt> updatedAt;


}
