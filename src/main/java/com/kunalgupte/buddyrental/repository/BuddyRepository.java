package com.kunalgupte.buddyrental.repository;

import com.kunalgupte.buddyrental.entities.Buddy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuddyRepository extends JpaRepository<Buddy, Long> {
}
