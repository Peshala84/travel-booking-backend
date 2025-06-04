package com.travelbooking.travelapp.service;

import com.travelbooking.travelapp.model.TravelPackage;
import com.travelbooking.travelapp.repository.TravelPackageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TravelPackageService {
    private final TravelPackageRepository packageRepo;

    public TravelPackageService(TravelPackageRepository packageRepo){
        this.packageRepo  = packageRepo;
    }

    public List<TravelPackage> getAllPackages(){
        return packageRepo.findAll();
    }

    public TravelPackage getPackageById(Long id){
        return packageRepo.findById(id)
                .orElseThrow( ()-> new RuntimeException("Package Not Found"+ id));
    }

    public TravelPackage savePackage(TravelPackage tp){
        return packageRepo.save(tp);
    }

}
