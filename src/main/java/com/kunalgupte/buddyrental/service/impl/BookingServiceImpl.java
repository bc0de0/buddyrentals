package com.kunalgupte.buddyrental.service.impl;

import com.kunalgupte.buddyrental.entities.Booking;
import com.kunalgupte.buddyrental.repository.BookingRepository;
import com.kunalgupte.buddyrental.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public Optional<Booking> getBookingById(Long id) {
        return bookingRepository.findById(id);
    }

    @Override
    public Optional<Booking> updateBooking(Long id, Booking bookingDetails) {
        return bookingRepository.findById(id).map(existingBooking -> {
            existingBooking.setUser(bookingDetails.getUser());
            existingBooking.setBuddy(bookingDetails.getBuddy());
            existingBooking.setBookingStartTime(bookingDetails.getBookingStartTime());
            existingBooking.setStartTime(bookingDetails.getStartTime());
            existingBooking.setEndTime(bookingDetails.getEndTime());
            existingBooking.setTotalPrice(bookingDetails.getTotalPrice());
            return bookingRepository.save(existingBooking);
        });
    }

    @Override
    public boolean deleteBooking(Long id) {
        return bookingRepository.findById(id).map(booking -> {
            bookingRepository.delete(booking);
            return true;
        }).orElse(false);
    }
}

