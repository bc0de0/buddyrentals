package com.kunalgupte.buddyrental.service.impl;

import com.kunalgupte.buddyrental.entities.Buddy;
import com.kunalgupte.buddyrental.repository.BuddyRepository;
import com.kunalgupte.buddyrental.service.BuddyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BuddyServiceImpl implements BuddyService {

    @Autowired
    private BuddyRepository buddyRepository;

    @Override
    public Buddy addBuddy(Buddy buddy) {
        return buddyRepository.save(buddy);
    }

    @Override
    public Optional<Buddy> getBuddyById(Long id) {
        return buddyRepository.findById(id);
    }

    @Override
    public List<Buddy> getAllBuddies() {
        return buddyRepository.findAll();
    }

    @Override
    public Buddy updateBuddy(Long id, Buddy buddyDetails) {
        return buddyRepository.findById(id)
                .map(existingBuddy -> {
                    existingBuddy.setName(buddyDetails.getName());
                    existingBuddy.setDob(buddyDetails.getDob());
                    existingBuddy.setGender(buddyDetails.getGender());
                    existingBuddy.setVehicle(buddyDetails.getVehicle());
                    existingBuddy.setLicense(buddyDetails.getLicense());
                    existingBuddy.setNumber(buddyDetails.getNumber());
                    // update other fields if needed
                    return buddyRepository.save(existingBuddy);
                })
                .orElseThrow(() -> new RuntimeException("Buddy not found with id " + id));
    }

    @Override
    public boolean deleteBuddy(Long id) {
        if (buddyRepository.existsById(id)) {
            buddyRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

