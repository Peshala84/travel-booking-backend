package com.travelbooking.travelapp.repository;

import com.travelbooking.travelapp.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
