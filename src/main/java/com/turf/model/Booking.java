package com.turf.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate bookingDate;

    private String status; 

    private String paymentStatus; 

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "slot_id")
    private TurfSlot slot;

    public Booking() {}

    public Booking(Long id, LocalDate bookingDate, String status, String paymentStatus, User user, TurfSlot slot) {
        this.id = id;
        this.bookingDate = bookingDate;
        this.status = status;
        this.paymentStatus = paymentStatus;
        this.user = user;
        this.slot = slot;
    }

    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getBookingDate() { return bookingDate; }
    public void setBookingDate(LocalDate bookingDate) { this.bookingDate = bookingDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getPaymentStatus() { return paymentStatus; }
    public void setPaymentStatus(String paymentStatus) { this.paymentStatus = paymentStatus; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public TurfSlot getSlot() { return slot; }
    public void setSlot(TurfSlot slot) { this.slot = slot; }
}