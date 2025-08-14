package com.kunalgupte.buddyrental.service.impl;

import com.kunalgupte.buddyrental.entities.Booking;
import com.kunalgupte.buddyrental.entities.Rental;
import com.kunalgupte.buddyrental.entities.User;
import com.kunalgupte.buddyrental.entities.enums.BookingStatus;
import com.kunalgupte.buddyrental.entities.enums.RentalStatus;
import com.kunalgupte.buddyrental.repository.BookingRepository;
import com.kunalgupte.buddyrental.repository.RentalRepository;
import com.kunalgupte.buddyrental.service.BookingService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private RentalRepository rentalRepository;

    @Override
    public Booking createBooking(Booking booking) {
        log.info("created new booking: {}", booking.getUser().getName());
        booking.setBookingCreatedAt(LocalDateTime.now());
        booking.setStatus(BookingStatus.PENDING);
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
        return bookingRepository.findById(id).map(existing -> {
            log.info("Pevious booking details: {}", existing.toString());
            existing.setRequestedStartTime(bookingDetails.getRequestedStartTime());
            existing.setRequestedEndTime(bookingDetails.getRequestedEndTime());
            existing.setEstimatedPrice(bookingDetails.getEstimatedPrice());
            existing.setStatus(bookingDetails.getStatus());
            return bookingRepository.save(existing);
        });
    }

    @Override
    public boolean deleteBooking(Long id) {
        return bookingRepository.findById(id).map(b -> {
            log.info("Booking cancelled by: {}", b.getUser().getName());
            bookingRepository.delete(b);
            return true;
        }).orElse(false);

    }

    /**
     * Transition from Booking to Rental (start rental)
     */
    public Optional<Rental> startRental(Long bookingId) {
        return bookingRepository.findById(bookingId).filter(b -> b.getStatus() == BookingStatus.CONFIRMED)
                .map(confirmedBooking -> {
                    Rental rental = Rental.builder()
                            .booking(confirmedBooking)
                            .actualPickupTime(LocalDateTime.now())
                            .finalPrice(confirmedBooking.getEstimatedPrice()) // may adjust later
                            .status(RentalStatus.ACTIVE)
                            .build();
                    return rentalRepository.save(rental);
                });
    }
}
