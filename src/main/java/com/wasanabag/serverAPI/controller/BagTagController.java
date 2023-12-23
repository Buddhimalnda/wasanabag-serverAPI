package com.wasanabag.serverAPI.controller;

import com.wasanabag.serverAPI.model.BagTag;
import com.wasanabag.serverAPI.servicer.BagTagService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@AllArgsConstructor
@RestController
@CrossOrigin(value = "http://localhost:3000")
@RequestMapping("/api/v1/bagtag")
public class BagTagController {
    private final BagTagService bagTagService;

    //create bagtag
    @PostMapping("/")
    public BagTag createBagTag(@RequestBody BagTag bagTag){
        return bagTagService.createBagTag(bagTag);
    }
    //update bagtag
    @PutMapping("/{code}")
    public BagTag updateBagTag(@PathVariable String code, @RequestBody BagTag bagTag){
        return bagTagService.updateBagTag(code, bagTag);
    }
    //delete bagtag
    @DeleteMapping("/{id}")
    public void deleteBagTag(@PathVariable String id){
        bagTagService.deleteBagTag(id);
    }
    //get bagtag by id
    @GetMapping("/{id}")
    public BagTag getBagTagById(@PathVariable String id){
        return bagTagService.getBagTagById(id);
    }
    //get all bagtags
    @GetMapping("/all")
    public List<BagTag> getAllBagTags(){
        return bagTagService.getAllBagTags();
    }
    @GetMapping("/tag")
    public BagTag getBagTagByTag(@RequestParam String tag){
        return bagTagService.getBagTagByTag(tag);
    }
    @PutMapping("/tag/{tag}")
    public BagTag updateBagTagByTag(@PathVariable String tag, @RequestBody BagTag bagTag){
        return bagTagService.updateBagTagByTag(tag, bagTag);
    }


}
