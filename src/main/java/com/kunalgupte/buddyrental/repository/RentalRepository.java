package com.kunalgupte.buddyrental.repository;

import com.kunalgupte.buddyrental.entities.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, Long> {
}
