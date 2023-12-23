package com.wasanabag.serverAPI.controller;


import com.wasanabag.serverAPI.model.Item;
import com.wasanabag.serverAPI.servicer.ItemService;
import com.wasanabag.serverAPI.types.Message;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
@RestController
@CrossOrigin(value = "http://localhost:3000")
@RequestMapping("/api/v1/item")
public class ItemController {
    private final ItemService itemService;
    @GetMapping("/all")
    public List<Item> getAllItems(){
        return itemService.getAllItems();
    }
    @PostMapping("/")
    public Item addItem(@RequestBody Item item){
        return itemService.addItem(item);
    }
    @GetMapping("/{id}")
    public Item getItemById(@PathVariable String id, @RequestHeader String header){
        return itemService.getItemById(id);
    }
    @GetMapping("/search")
    public List<Optional<Item>> searchItem(@RequestParam String search){
        return itemService.searchItem(search);
    }
    @PutMapping("/")
    public Item updateItem(@RequestBody Item item){
        return itemService.updateItem(item);
    }
    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable String id, @RequestHeader String header){
        itemService.deleteItem(id);
    }


}
