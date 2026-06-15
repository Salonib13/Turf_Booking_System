package com.turf.service.impl;

import com.turf.model.Booking;
import com.turf.repository.BookingRepository;
import com.turf.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public String processPayment(Long bookingId) {

        Booking booking = bookingRepository.findById(bookingId).orElse(null);

        if (booking == null) {
            return "Booking not found";
        }

        String[] status = {"PAID", "FAILED"};
        String result = status[new Random().nextInt(status.length)];

        booking.setPaymentStatus(result);

        if (result.equals("PAID")) {
            booking.setStatus("CONFIRMED");
        } else {
            booking.setStatus("PENDING");
        }

        bookingRepository.save(booking);

        return "Payment " + result;
    }
}