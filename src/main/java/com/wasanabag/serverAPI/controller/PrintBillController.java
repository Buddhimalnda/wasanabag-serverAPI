package com.wasanabag.serverAPI.controller;

import com.wasanabag.serverAPI.model.Order;
import com.wasanabag.serverAPI.model.PrintingBill;
import com.wasanabag.serverAPI.repository.OrderRepository;
import com.wasanabag.serverAPI.servicer.OrderService;
import com.wasanabag.serverAPI.servicer.PrintBillService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/bill")
public class PrintBillController {
    private final PrintBillService printBillService;
    private final OrderRepository orderRepository;

    @PostMapping("/")
    public String printBill(@RequestBody Bill bill){
        List<Order> orders = orderRepository.findAllById(bill.getOrders());
//        for (String id : bill.getOrders()) {
//
//            Optional<Order> o =;
//            if (o.isPresent()){
//                System.out.println(o.get().getId());
//                assert false;
//
//            }
//            else
//                System.out.println("not present");
//        }
//        return "hello";
        return printBillService.printBill(orders, bill.getPaid(), bill.getDiscount());
    }



}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Bill{
    private List<String> orders;
    private double paid;
    private double discount;
}