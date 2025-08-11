package com.kunalgupte.buddyrental.entities;

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

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "buddy_id", nullable = false)
    private Buddy buddy;

    private LocalDateTime bookingStartTime;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    private double totalPrice;
}

