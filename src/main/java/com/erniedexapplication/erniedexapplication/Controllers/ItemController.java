package com.erniedexapplication.erniedexapplication.Controllers;


import com.erniedexapplication.erniedexapplication.Models.Item;
import com.erniedexapplication.erniedexapplication.Models.ItemType;
import com.erniedexapplication.erniedexapplication.Models.SimpleItemDisplay;
import com.erniedexapplication.erniedexapplication.Repositories.ItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemDao itemDao;

    @GetMapping("/all")
    public List<Item> getAllShirts() {
        return itemDao.getAllItems();
    }

    @GetMapping("/{id}")
    public Item getItemById(@PathVariable("id") UUID id){
        return  itemDao.getItemById(id);
    }

    @PostMapping
    public Item addItem(@RequestBody Item item) {
        return itemDao.addItem(item);
    }

    @DeleteMapping("/{id}")
    public boolean deleteItem(@PathVariable("id") UUID id){
        return itemDao.deleteItem(id);
    }

    @PutMapping("{id}")
    public Item updateItem(@PathVariable("id")UUID id, @RequestBody Item item){
        return itemDao.updateItem(item);
    }

    @GetMapping("/types")
    public List<SimpleItemDisplay> getGroupedItems(){
        return itemDao.getGroupedItems();
    }

}
