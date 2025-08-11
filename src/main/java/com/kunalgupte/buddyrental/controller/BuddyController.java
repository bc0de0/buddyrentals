package com.kunalgupte.buddyrental.controller;

import com.kunalgupte.buddyrental.entities.Buddy;
import com.kunalgupte.buddyrental.service.BuddyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/buddies")
public class BuddyController {

    @Autowired
    private BuddyService buddyService;

    // CREATE
    @PostMapping
    public ResponseEntity<Buddy> addBuddy(@RequestBody Buddy buddy) {
        Buddy savedBuddy = buddyService.addBuddy(buddy);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBuddy);
    }

    // READ (Get All)
    @GetMapping
    public ResponseEntity<List<Buddy>> getAllBuddies() {
        List<Buddy> buddies = buddyService.getAllBuddies();
        return ResponseEntity.ok(buddies);
    }

    // READ (Get One)
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Buddy>> getBuddyById(@PathVariable Long id) {
        Optional<Buddy> buddy = buddyService.getBuddyById(id);
        if (buddy.isPresent()) {
            return ResponseEntity.ok(buddy);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Buddy> updateBuddy(@PathVariable Long id, @RequestBody Buddy buddy) {
        Buddy updatedBuddy = buddyService.updateBuddy(id, buddy);
        if (updatedBuddy != null) {
            return ResponseEntity.ok(updatedBuddy);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteBuddy(@PathVariable Long id) {
        boolean deletedBuddy = buddyService.deleteBuddy(id);
        if (deletedBuddy) {
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
