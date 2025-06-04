package com.travelbooking.travelapp.repository;

import com.travelbooking.travelapp.model.TravelPackage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravelPackageRepository extends JpaRepository<TravelPackage, Long> {
}
