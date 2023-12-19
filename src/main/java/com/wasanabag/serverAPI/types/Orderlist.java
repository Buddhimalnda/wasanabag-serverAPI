package com.wasanabag.serverAPI.types;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Orderlist<X,Y> {
    X x;
    Y y;
}
