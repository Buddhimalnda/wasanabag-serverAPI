package com.wasanabag.serverAPI.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "attendance")
public class Attendance {
    @Id
    private String id;
    private String userId;
    private String date;
    private String time;
    private String status;


}
