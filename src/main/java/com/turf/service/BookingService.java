package com.turf.service;

import com.turf.dto.BookingRequest;
import com.turf.model.Booking;

import java.time.LocalDate;
import java.util.List;

public interface BookingService {

	Booking createBooking(BookingRequest request);

    Booking getBookingById(Long id);

    List<Booking> getBookingsByDate(LocalDate date);

    List<Booking> getAllBookings();

    Booking cancelBooking(Long id);

    void deleteBooking(Long id);
    List<Booking> getBookingsByUser(Long userId);
}