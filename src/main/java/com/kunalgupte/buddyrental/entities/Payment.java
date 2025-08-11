package com.kunalgupte.buddyrental.entities;

import com.kunalgupte.buddyrental.entities.enums.PaymentStatus;
import com.kunalgupte.buddyrental.entities.enums.PaymentType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "booking_id", nullable = false)
    private Booking booking;

    private LocalDateTime bookingToJourneyEstimate;

    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;

    private double amount;

    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

}

