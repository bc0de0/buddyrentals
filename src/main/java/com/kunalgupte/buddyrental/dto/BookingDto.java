package com.kunalgupte.buddyrental.dto;

import com.kunalgupte.buddyrental.entities.Buddy;
import com.kunalgupte.buddyrental.entities.User;
import com.kunalgupte.buddyrental.entities.enums.BookingStatus;

import java.time.LocalDateTime;

public record BookingDto(
        Long id,
        User user,
        Buddy buddy,
        LocalDateTime requestedStartTime,
        LocalDateTime requestedEndTime,
        Double estimatedPrice,
        LocalDateTime bookingCreatedAt,
        BookingStatus bookingStatus
) {
}
