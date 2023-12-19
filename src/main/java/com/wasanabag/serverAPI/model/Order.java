package com.wasanabag.serverAPI.model;

import com.wasanabag.serverAPI.types.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "order")
@AllArgsConstructor
public class Order {
    @Id
    private String id;
    private List<Orderlist<Item, Integer>> list;
    private String date;
    private String time;
    private String address;
    private String phone;
    private String email;
    private String name;
    private PaymentType paymentType;
    private PaymentStatus paymentStatus;
    private OrderStatus orderStatus;
    private String note;
    private Integer total;
    private TimeAt createdAt;
    private List<TimeAt> updatedAt;

    public Order(List<Orderlist<Item, Integer>> list, String date, String time, String address, String phone, String email, String name, PaymentType paymentType,PaymentStatus paymentStatus, OrderStatus orderStatus, String note) {
        this.list = list;
        this.date = date;
        this.time = time;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.name = name;
        this.paymentType = paymentType;
        this.note = note;
        for (Orderlist<Item, Integer> order : list) {
            this.total += ((order.getX().getPrice()) * order.getY());
        }
    }

}
