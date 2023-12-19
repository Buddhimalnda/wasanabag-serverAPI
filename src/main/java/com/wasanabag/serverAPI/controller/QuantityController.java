package com.wasanabag.serverAPI.controller;


import com.wasanabag.serverAPI.model.Quantity;
import com.wasanabag.serverAPI.servicer.QuantityService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/quantity")
public class QuantityController {
    private final QuantityService quantityService;
    @GetMapping("/all")
    public List<Quantity> getAllQuantity(){
        return quantityService.getAllQuantity();
    }
    @PostMapping("/create")
    public Quantity createQuantity(@RequestBody Quantity quantity){
        return quantityService.createQuantity(quantity);
    }
    @PutMapping("/update")
    public Quantity updateQuantity(@RequestBody Quantity quantity){
        return quantityService.updateQuantity(quantity);
    }
    @GetMapping("/find/{code}")
    public Quantity getQuantityByCode(@PathVariable String code){
        return quantityService.getQuantityByCode(code);
    }
//    @GetMapping("/find/")
    @DeleteMapping("/{id}")
    public void deleteQuantity(@PathVariable String id){
        quantityService.deleteQuantity(id);
    }
}

