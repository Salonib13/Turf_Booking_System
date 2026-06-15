package com.turf.repository;

import com.turf.model.TurfSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SlotRepository extends JpaRepository<TurfSlot, Long> {
}