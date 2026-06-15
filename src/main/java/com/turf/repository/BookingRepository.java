package com.turf.repository;
import java.time.LocalDate;

import com.turf.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    
    List<Booking> findByBookingDate(LocalDate bookingDate);
    boolean existsByBookingDateAndSlotId(
            LocalDate bookingDate,
            Long slotId
    );
    List<Booking> findByUserId(Long userId);
}