package com.burger_haven.Controller;

import com.burger_haven.Entity.Item;
import com.burger_haven.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
@CrossOrigin("http://localhost:4200")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping ("/all")
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @PostMapping ("/add")
    public Item addItem(@RequestBody Item item) {
        return itemService.saveItem(item);
    }

    @GetMapping("/{id}")
    public Item getItemById(@PathVariable Long id) {
        return itemService.getItemById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
        return "Item deleted successfully!";
    }
}