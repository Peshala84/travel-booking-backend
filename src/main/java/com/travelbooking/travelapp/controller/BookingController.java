package com.travelbooking.travelapp.controller;


import com.travelbooking.travelapp.model.Booking;
import com.travelbooking.travelapp.service.BookingService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins = "http://localhost:5173")
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public ResponseEntity<Booking> createBooking(
            @RequestParam("packageId") Long packageId,
            @Valid @RequestBody Booking bookingRequest) {
        Booking saved = bookingService.createBooking(packageId, bookingRequest);
        return ResponseEntity.status(201).body(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBooking(@PathVariable Long id) {
        Booking b = bookingService.getBookingById(id);
        return ResponseEntity.ok(b);
    }
}
