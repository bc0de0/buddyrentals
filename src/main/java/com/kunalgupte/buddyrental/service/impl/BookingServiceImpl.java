package com.kunalgupte.buddyrental.service.impl;

import com.kunalgupte.buddyrental.dto.BookingDto;
import com.kunalgupte.buddyrental.entities.Booking;
import com.kunalgupte.buddyrental.dto.mapper.BookingMapper;
import com.kunalgupte.buddyrental.repository.BookingRepository;
import com.kunalgupte.buddyrental.service.BookingService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public BookingDto createBooking(BookingDto bookingDto) {
        Booking booking = BookingMapper.toEntity(bookingDto);
        booking.setBookingCreatedAt(LocalDateTime.now());
        Booking saved = bookingRepository.save(booking);
        return BookingMapper.toDto(saved);
    }

    @Override
    public List<BookingDto> getAllBookings() {
        return bookingRepository.findAll()
                .stream()
                .map(BookingMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public BookingDto getBookingById(Long id) {
        return bookingRepository.findById(id)
                .map(BookingMapper::toDto)
                .orElse(null);
    }

    @Override
    public BookingDto updateBooking(Long id, BookingDto bookingDto) {
        Optional<Booking> existingOpt = bookingRepository.findById(id);
        if (existingOpt.isEmpty()) return null;

        Booking booking = existingOpt.get();
        booking.setUser(bookingDto.user());
        booking.setBuddy(bookingDto.buddy());
        booking.setRequestedStartTime(bookingDto.requestedStartTime());
        booking.setRequestedEndTime(bookingDto.requestedEndTime());
        booking.setEstimatedPrice(bookingDto.estimatedPrice());
        booking.setStatus(bookingDto.bookingStatus());

        Booking updated = bookingRepository.save(booking);
        return BookingMapper.toDto(updated);
    }

    @Override
    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }
}
