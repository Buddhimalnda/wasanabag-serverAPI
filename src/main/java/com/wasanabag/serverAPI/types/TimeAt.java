package com.wasanabag.serverAPI.types;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class TimeAt {
    private String time;
    private String date;
    private String auth;
}
