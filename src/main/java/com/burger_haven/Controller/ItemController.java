package com.burger_haven.Controller;

import com.burger_haven.Entity.Item;
import com.burger_haven.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/items")
@CrossOrigin(origins = "http://localhost:4200")
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

    @DeleteMapping("/delete/{id}")
    public String deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
        return "Item deleted successfully!";
    }
    @PutMapping("/update-status/{id}")
    public Item updateItemStatus(@PathVariable Long id, @RequestBody Map<String, String> statusUpdate) {
        Item item = itemService.getItemById(id);
        if (item != null) {
            item.setStatus(statusUpdate.get("status"));
            return itemService.saveItem(item);
        }
        return null;
    }
}