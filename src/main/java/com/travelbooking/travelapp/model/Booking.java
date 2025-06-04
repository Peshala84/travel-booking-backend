package com.travelbooking.travelapp.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
@Data
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "package_id",nullable=false)
    private TravelPackage travelPackage;

    private String firstName;
    private String lastName;

//    @Email
    private String email;

    private String phone;
    private Integer travelers;
    private LocalDate travelDate;

    private String specialRequests;

    private String cardNumber;
    private String cardName;
    private String expiry;
    private String cvv;

    @CreationTimestamp
    private LocalDateTime bookedAt;
}
