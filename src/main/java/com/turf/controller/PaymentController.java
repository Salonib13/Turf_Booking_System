package com.turf.controller;

import com.turf.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
@CrossOrigin(origins = "*")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    
    @PostMapping("/process/{bookingId}")
    public String processPayment(@PathVariable Long bookingId) {
        return paymentService.processPayment(bookingId);
    }
}