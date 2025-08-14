package com.kunalgupte.buddyrental.dto.mapper;

import com.kunalgupte.buddyrental.dto.BookingDto;
import com.kunalgupte.buddyrental.entities.Booking;

public class BookingMapper {

    public static BookingDto toDto(Booking booking) {
        if (booking == null) return null;

        return new BookingDto(
                booking.getId(),
                booking.getUser(),
                booking.getBuddy(),
                booking.getRequestedStartTime(),
                booking.getRequestedEndTime(),
                booking.getEstimatedPrice(),
                booking.getBookingCreatedAt(),
                booking.getStatus()
        );
    }

    public static Booking toEntity(BookingDto dto) {
        if (dto == null) return null;

        return Booking.builder()
                .id(dto.id())
                .user(dto.user())
                .buddy(dto.buddy())
                .requestedStartTime(dto.requestedStartTime())
                .requestedEndTime(dto.requestedEndTime())
                .estimatedPrice(dto.estimatedPrice())
                .bookingCreatedAt(dto.bookingCreatedAt())
                .status(dto.bookingStatus())
                .build();
    }
}

