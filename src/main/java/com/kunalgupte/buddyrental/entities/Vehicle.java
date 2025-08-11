package com.kunalgupte.buddyrental.entities;

import com.kunalgupte.buddyrental.entities.enums.VehicleStatus;
import com.kunalgupte.buddyrental.entities.enums.VehicleType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "vehicles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private VehicleType type;    // CAR, BIKE, SCOOTER

    private String make;         // manufacturer
    private String model;
    private String registrationNumber;

    private Integer year;

    private String location;     // simple text for now (city/branch)

    @Enumerated(EnumType.STRING)
    private VehicleStatus status; // AVAILABLE, BOOKED, MAINTENANCE

    private double baseRatePerHour; // keep double for now (we can switch to BigDecimal later)

    private Double odometer;     // nullable, optional

    private Double fuelPercentage;
}

