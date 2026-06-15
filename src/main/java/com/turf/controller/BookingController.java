package com.turf.controller;

import com.turf.dto.BookingRequest;
import com.turf.model.Booking;
import com.turf.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins = "*")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    
    @PostMapping("/create")
    public Booking createBooking(@RequestBody BookingRequest request) {
        return bookingService.createBooking(request);
    }

    
    @GetMapping("/{id}")
    public Booking getBookingById(@PathVariable Long id) {
        return bookingService.getBookingById(id);
    }

    
    @GetMapping("/date/{date}")
    public List<Booking> getBookingsByDate(@PathVariable String date) {
        return bookingService.getBookingsByDate(LocalDate.parse(date));
    }

    
    @PutMapping("/cancel/{id}")
    public Booking cancelBooking(@PathVariable Long id) {
        return bookingService.cancelBooking(id);
    }

    
    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }
    
}