package com.kunalgupte.buddyrental.entities;

import com.kunalgupte.buddyrental.entities.enums.BookingStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // The user making the booking
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // The buddy being booked (could be linked to a vehicle if needed)
    @ManyToOne
    @JoinColumn(name = "buddy_id", nullable = false)
    private Buddy buddy;

    // Requested times
    private LocalDateTime requestedStartTime;
    private LocalDateTime requestedEndTime;

    // Estimated cost before rental starts
    private double estimatedPrice;

    // Created timestamp
    private LocalDateTime bookingCreatedAt;

    @Enumerated(EnumType.STRING)
    private BookingStatus status; // PENDING, CONFIRMED, CANCELLED

}


