package com.kunalgupte.buddyrental.repository;

import com.kunalgupte.buddyrental.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Book;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
