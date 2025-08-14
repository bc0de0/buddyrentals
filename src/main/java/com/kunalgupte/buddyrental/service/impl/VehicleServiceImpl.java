package com.kunalgupte.buddyrental.service.impl;

import com.kunalgupte.buddyrental.entities.Vehicle;
import com.kunalgupte.buddyrental.repository.VehicleRepository;
import com.kunalgupte.buddyrental.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleRepository vehicleRepository;

    @Override
    public Vehicle addVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return List.of((Vehicle) vehicleRepository.findAll());
    }

    @Override
    public Optional<Vehicle> getVehicleById(Long id) {
        return vehicleRepository.findById(id);
    }

    @Override
    public Optional<Vehicle> updateVehicle(Long id, Vehicle vehicleDetails) {
        return vehicleRepository.findById(id).map(existingVehicle -> {
            existingVehicle.setType(vehicleDetails.getType());
            existingVehicle.setMake(vehicleDetails.getMake());
            existingVehicle.setLocation(vehicleDetails.getLocation());
            return vehicleRepository.save(existingVehicle);
        });
    }

    @Override
    public boolean deleteVehicle(Long id) {
        if(vehicleRepository.existsById(id)){
            vehicleRepository.deleteById(id);
            return true;
        }
        else return false;
    }
}
