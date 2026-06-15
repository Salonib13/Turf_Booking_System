package com.turf.controller;

import com.turf.model.Booking;
import com.turf.service.BookingService;
import com.turf.service.SlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "*")
public class AdminController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private SlotService slotService;

    
    @GetMapping("/bookings")
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    
    @DeleteMapping("/booking/{id}")
    public String deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
        return "Booking deleted by admin";
    }

    
    @PutMapping("/block-slot/{id}")
    public String blockSlot(@PathVariable Long id) {
        slotService.blockSlot(id);
        return "Slot blocked";
    }

   
    @PutMapping("/unblock-slot/{id}")
    public String unblockSlot(@PathVariable Long id) {
        slotService.unblockSlot(id);
        return "Slot unblocked";
    }
}