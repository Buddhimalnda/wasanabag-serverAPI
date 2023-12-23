package com.wasanabag.serverAPI.model;

import com.wasanabag.serverAPI.types.TagStatus;
import com.wasanabag.serverAPI.types.TimeAt;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "bagtag")
public class BagTag {
    @Id
    private String id;
    private String code;
    private String Tag;
    private TagStatus status;
    private TimeAt createdAt;
    private List<TimeAt> updatedAt;
}
