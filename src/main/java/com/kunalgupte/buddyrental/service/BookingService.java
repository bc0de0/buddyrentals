package com.kunalgupte.buddyrental.service;

import com.kunalgupte.buddyrental.entities.Booking;

import java.util.List;
import java.util.Optional;

public interface BookingService {
    Booking createBooking(Booking booking);
    List<Booking> getAllBookings();
    Optional<Booking> getBookingById(Long id);
    Optional<Booking> updateBooking(Long id, Booking bookingDetails);
    boolean deleteBooking(Long id);
}

