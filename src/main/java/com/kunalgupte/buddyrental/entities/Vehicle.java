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

    // Owning side of OneToOne
    @OneToOne
    @JoinColumn(name = "buddy_id")
    private Buddy buddy;

    @Enumerated(EnumType.STRING)
    private VehicleType type;    // CAR, BIKE, SCOOTER

    private String make;         // manufacturer
    private String model;
    private String registrationNumber;

    private Integer manufactureYear;

    private String location;     // city/branch

    @Enumerated(EnumType.STRING)
    private VehicleStatus status; // AVAILABLE, BOOKED, MAINTENANCE

    // H2-compatible numeric fields
    private double baseRatePerHour;  // double primitive
    private Double odometer;         // nullable
    private Double fuelPercentage;   // nullable
}
