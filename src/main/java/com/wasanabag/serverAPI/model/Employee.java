package com.wasanabag.serverAPI.model;


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
@Document(collection = "employee")
public class Employee {
    @Id
    private String id;
    private String name;
    private String email;
    private String password;
    private String phone;
    private String address;
    private String role;
    private String status;
    private TimeAt createdAt;
    private List<TimeAt> updatedAt;

}
