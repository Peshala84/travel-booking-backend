package com.travelbooking.travelapp.service;


import com.travelbooking.travelapp.model.Booking;
import com.travelbooking.travelapp.model.TravelPackage;
import com.travelbooking.travelapp.repository.BookingRepository;
import com.travelbooking.travelapp.repository.TravelPackageRepository;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    private final BookingRepository bookingRepo;
    private final TravelPackageRepository packageRepo;

    public BookingService(BookingRepository bookingRepo, TravelPackageRepository packageRepo){
        this.bookingRepo = bookingRepo;
        this.packageRepo = packageRepo;
    }
    public Booking createBooking(Long packageId, Booking bookingRequest) {
        TravelPackage tp = packageRepo.findById(packageId)
                .orElseThrow(() -> new RuntimeException("Package not found: " + packageId));

        bookingRequest.setTravelPackage(tp);
        return bookingRepo.save(bookingRequest);
    }

    public Booking getBookingById(Long id) {
        return bookingRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found: " + id));
    }
}
