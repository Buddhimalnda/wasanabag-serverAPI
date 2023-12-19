package com.wasanabag.serverAPI.servicer;


import com.wasanabag.serverAPI.model.Order;
import com.wasanabag.serverAPI.repository.OrderRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
@Service
public class OrderService {
    private final OrderRepository orderRepository;


    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order checkOrderById(String id) {
        return orderRepository.findById(id).orElse(null);
    }

    public List<Optional<Order>> checkOrderByDate(String date) {
        return orderRepository.findByDate(date);
    }

    public List<Optional<Order>> newOrders() {
        return orderRepository.findByOrderByCreatedAtDateAsc();
    }

    public Order updateOrder(Order order) {
        Order existingOrder = orderRepository.findById(order.getId()).orElseThrow(null);
        existingOrder.setList(order.getList());
        existingOrder.setDate(order.getDate());
        existingOrder.setTotal(order.getTotal());
        existingOrder.setTime(order.getTime());
        existingOrder.setEmail(order.getEmail());
        existingOrder.setPhone(order.getPhone());
        existingOrder.setAddress(order.getAddress());
        existingOrder.setPaymentType(order.getPaymentType());
        existingOrder.setPaymentStatus(order.getPaymentStatus());
        existingOrder.setOrderStatus(order.getOrderStatus());
        existingOrder.setUpdatedAt(order.getUpdatedAt());
        existingOrder.setName(order.getName());
        existingOrder.setNote(order.getNote());
        return orderRepository.save(existingOrder);
    }

    public void deleteOrder(String id) {
        orderRepository.deleteById(id);
    }
}
