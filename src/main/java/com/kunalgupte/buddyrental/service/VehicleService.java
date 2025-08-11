package com.kunalgupte.buddyrental.service;

import com.kunalgupte.buddyrental.entities.Vehicle;

import java.util.List;
import java.util.Optional;

public interface VehicleService {
    Vehicle addVehicle(Vehicle vehicle);

    List<Vehicle> getAllVehicles();

    Optional<Vehicle> getVehicleById(Long id);

    Optional<Vehicle> updateVehicle(Long id, Vehicle vehicleDetails);

    boolean deleteVehicle(Long id);
}
