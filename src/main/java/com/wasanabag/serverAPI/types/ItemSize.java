package com.wasanabag.serverAPI.types;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class ItemSize {
    private Integer width;
    private Integer height;
    private Integer depth;
    private Integer weight;
    private String[] units; // ["mm", "mm", "mm","l"]

    private Integer maxWeight;
    private char max_units; // l

}
