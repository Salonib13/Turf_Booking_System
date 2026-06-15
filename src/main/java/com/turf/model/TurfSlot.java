package com.turf.model;

import jakarta.persistence.*;

@Entity
@Table(name = "turf_slots")
public class TurfSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_time")
    private String startTime;

    @Column(name = "end_time")
    private String endTime;

    private boolean blocked;

    public TurfSlot() {
    }

    public TurfSlot(Long id, String startTime, String endTime, boolean blocked) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.blocked = blocked;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }
}