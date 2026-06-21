package com.turf.service.impl;

import com.turf.dto.BookingRequest;

import com.turf.model.Booking;
import com.turf.model.TurfSlot;
import com.turf.model.User;
import com.turf.repository.BookingRepository;
import com.turf.repository.SlotRepository;
import com.turf.repository.UserRepository;
import com.turf.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SlotRepository slotRepository;

    @Override
    public Booking createBooking(BookingRequest request) {

        
        boolean alreadyBooked =
                bookingRepository.existsByBookingDateAndSlotId(
                        request.getBookingDate(),
                        request.getSlotId()
                );

        if(alreadyBooked){
            throw new RuntimeException(
                "This slot is already booked for selected date"
            );
        }

        User user = userRepository.findById(request.getUserId()).orElse(null);
        TurfSlot slot = slotRepository.findById(request.getSlotId()).orElse(null);

        Booking booking = new Booking();

        booking.setUser(user);
        booking.setSlot(slot);
        booking.setBookingDate(request.getBookingDate());
        booking.setPaymentStatus(request.getPaymentStatus());
        booking.setStatus("CONFIRMED");

        return bookingRepository.save(booking);
    }
    @Override
    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id).orElse(null);
    }

    @Override
    public List<Booking> getBookingsByDate(LocalDate date) {
        return bookingRepository.findByBookingDate(date);
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking cancelBooking(Long id) {
        Booking booking = bookingRepository.findById(id).orElse(null);

        if (booking == null) {
            throw new RuntimeException("Booking not found");
        }

        if ("CANCELLED".equals(booking.getStatus())) {
            throw new RuntimeException("Already cancelled");
        }

        booking.setStatus("CANCELLED");
        return bookingRepository.save(booking);
    }
    @Override
    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }
    
    @Override
    public List<Booking> getBookingsByUser(Long userId) {
        return bookingRepository.findByUserId(userId);
    }
}