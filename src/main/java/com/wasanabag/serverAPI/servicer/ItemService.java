package com.wasanabag.serverAPI.servicer;

import com.wasanabag.serverAPI.log.Logger;
import com.wasanabag.serverAPI.log.LoggerService;
import com.wasanabag.serverAPI.model.Item;
import com.wasanabag.serverAPI.repository.ItemRepository;
import com.wasanabag.serverAPI.types.Message;
import com.wasanabag.serverAPI.types.StatusForLogger;
import com.wasanabag.serverAPI.types.TimeAt;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
@Service
public class ItemService {
    private final ItemRepository itemRepository;
//    private final UserRepository userRepository;
//    private final JwtService jwtService;
//    private final UserDetailsService userDetailsService;
    private final LoggerService loggerService;



    public List<Item> getAllItems() {

//        User user = userRepository.findByEmail(new Auth(jwtService, userDetailsService).getUser(req)).orElseThrow();
        loggerService.createLogger(
                new Logger(
                        "user.getId()",
                        "getAllItems",
                        "GET_ITEM_ALL",
                        StatusForLogger.PENDING,
                        new TimeAt(new Date().getTime()+"", new Date().getDate()+"", "BySystem"),
                        new TimeAt(new Date().getTime()+"", new Date().getDate()+"", "BySystem")
                )
        );
        Message<List<Item>> message = new Message<>(itemRepository.findAll(), "user.getId()", "getAllItems", 200);
        loggerService.createLogger(
                new Logger(
                        "user.getId()",
                        "getAllItems",
                        "GET_ITEM_ALL",
                        StatusForLogger.SUCCESS,
                        new TimeAt(new Date().getTime()+"", new Date().getDate()+"", "BySystem"),
                        new TimeAt(new Date().getTime()+"",new Date().getDate()+"", "BySystem")
                )
        );
        return itemRepository.findAll();
    }

    public Item addItem(Item item) {
        return itemRepository.insert(item);
    }


    public Item getItemById(String id) {
        return itemRepository.findById(id).orElse(null);
    }

    public List<Optional<Item>> searchItem(String name) {
        return itemRepository.findByName(name);
    }

    public Item updateItem(Item item) {
        Item existingItem = itemRepository.findById(item.getId()).orElseThrow(null);
        existingItem.setName(item.getName());
        existingItem.setPrice(item.getPrice());
        existingItem.setCategory(item.getCategory());
        existingItem.setImage(item.getImage());
        existingItem.setTags(item.getTags());
        existingItem.setSize(item.getSize());
        existingItem.setColor(item.getColor());
//        existingItem.setDiscount(item.getDiscount());
        existingItem.setDescription(item.getDescription());
        existingItem.setUpdatedAt(item.getUpdatedAt());
        return itemRepository.save(existingItem);
    }

    public void deleteItem(String id) {
        itemRepository.deleteById(id);
    }





}
