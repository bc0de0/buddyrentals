package com.kunalgupte.buddyrental.service;

import com.kunalgupte.buddyrental.entities.Buddy;

import java.util.List;
import java.util.Optional;

public interface BuddyService {

    Buddy addBuddy(Buddy buddy);
    Optional<Buddy> getBuddyById(Long id);
    List<Buddy> getAllBuddies();
    Buddy updateBuddy(Long id, Buddy buddyDetails);
    boolean deleteBuddy(Long id);
}
