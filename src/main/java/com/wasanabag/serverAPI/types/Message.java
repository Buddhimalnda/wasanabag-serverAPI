package com.wasanabag.serverAPI.types;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message <X>{
    X dataset;
    String userId;
    String message;
    int status;
}
