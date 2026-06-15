package com.turf.service;

import com.turf.model.TurfSlot;

import java.util.List;

public interface SlotService {

    TurfSlot addSlot(TurfSlot slot);

    List<TurfSlot> getAllSlots();

    TurfSlot blockSlot(Long id);

    TurfSlot unblockSlot(Long id);

    void deleteSlot(Long id);
}