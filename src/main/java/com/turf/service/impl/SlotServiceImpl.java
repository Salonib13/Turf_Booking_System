package com.turf.service.impl;

import com.turf.model.TurfSlot;
import com.turf.repository.SlotRepository;
import com.turf.service.SlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SlotServiceImpl implements SlotService {

    @Autowired
    private SlotRepository slotRepository;

    @Override
    public TurfSlot addSlot(TurfSlot slot) {
        slot.setBlocked(false);
        return slotRepository.save(slot);
    }

    @Override
    public List<TurfSlot> getAllSlots() {
        return slotRepository.findAll();
    }

    @Override
    public TurfSlot blockSlot(Long id) {
        TurfSlot slot = slotRepository.findById(id).orElse(null);
        if (slot != null) {
            slot.setBlocked(true);
            return slotRepository.save(slot);
        }
        return null;
    }

    @Override
    public TurfSlot unblockSlot(Long id) {
        TurfSlot slot = slotRepository.findById(id).orElse(null);
        if (slot != null) {
            slot.setBlocked(false);
            return slotRepository.save(slot);
        }
        return null;
    }

    @Override
    public void deleteSlot(Long id) {
        slotRepository.deleteById(id);
    }
}