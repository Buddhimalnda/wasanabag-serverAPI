package com.wasanabag.serverAPI.controller;

import com.wasanabag.serverAPI.model.Order;
import com.wasanabag.serverAPI.servicer.OrderService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/order")
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/all")
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }
    @PostMapping("/create")
    public Order createOrder(@RequestBody Order order){
        return orderService.createOrder(order);
    }

    @GetMapping("/check/id/{id}")
    public Order checkOrderById(@PathVariable String id){
        return orderService.checkOrderById(id);
    }
    @GetMapping("/check/date/{date}")
    public List<Optional<Order>> checkOrderByDate(@PathVariable String date){
        return orderService.checkOrderByDate(date);
    }

    @GetMapping("/new")
    public List<Optional<Order>> newOrders(){
        return orderService.newOrders();
    }

    @PutMapping("/")
    public Order updateOrder(@RequestBody Order order){
        return orderService.updateOrder(order);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable String id){
        orderService.deleteOrder(id);
    }
}
