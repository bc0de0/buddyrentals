package com.kunalgupte.buddyrental.repository;

import com.kunalgupte.buddyrental.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
