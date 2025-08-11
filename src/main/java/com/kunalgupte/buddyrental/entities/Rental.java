package com.kunalgupte.buddyrental.entities;

import com.kunalgupte.buddyrental.entities.enums.RentalStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "rentals")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Link to the booking that created this rental
    @OneToOne
    @JoinColumn(name = "booking_id", nullable = false)
    private Booking booking;

    // Actual start and end times of the rental
    private LocalDateTime actualPickupTime;
    private LocalDateTime actualReturnTime;

    // Price details
    private double finalPrice;
    private double extraCharges; // late fee, damage, etc.

    // Vehicle/buddy condition logs (optional)
    @Column(length = 1000)
    private String conditionNotesBefore;

    @Column(length = 1000)
    private String conditionNotesAfter;

    // Mileage tracking if applicable
    private Double mileageStart;
    private Double mileageEnd;

    @Enumerated(EnumType.STRING)
    private RentalStatus status; // ACTIVE, COMPLETED, OVERDUE
}
