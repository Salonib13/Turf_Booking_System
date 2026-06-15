package com.turf.controller;

import com.turf.model.TurfSlot;
import com.turf.service.SlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/slots")
@CrossOrigin(origins = "*")
public class SlotController {

    @Autowired
    private SlotService slotService;

    
    @PostMapping("/add")
    public TurfSlot addSlot(@RequestBody TurfSlot slot) {
        return slotService.addSlot(slot);
    }

    
    @GetMapping
    public List<TurfSlot> getAllSlots() {
        return slotService.getAllSlots();
    }

    
    @PutMapping("/block/{id}")
    public TurfSlot blockSlot(@PathVariable Long id) {
        return slotService.blockSlot(id);
    }

   
    @PutMapping("/unblock/{id}")
    public TurfSlot unblockSlot(@PathVariable Long id) {
        return slotService.unblockSlot(id);
    }

    
    @DeleteMapping("/{id}")
    public String deleteSlot(@PathVariable Long id) {
        slotService.deleteSlot(id);
        return "Slot deleted successfully";
    }
}