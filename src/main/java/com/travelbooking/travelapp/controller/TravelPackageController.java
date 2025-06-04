package com.travelbooking.travelapp.controller;

import com.travelbooking.travelapp.model.TravelPackage;
import com.travelbooking.travelapp.service.TravelPackageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/packages")
@CrossOrigin(origins = "http://localhost:5173")
public class TravelPackageController {
    private final TravelPackageService packageService;

    public TravelPackageController(TravelPackageService packageService) {
        this.packageService = packageService;
    }

    @GetMapping
    public ResponseEntity<List<TravelPackage>> getAllPackages() {
        List<TravelPackage> packages = packageService.getAllPackages();
        return ResponseEntity.ok(packages);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TravelPackage> getPackageById(@PathVariable Long id) {
        TravelPackage tp = packageService.getPackageById(id);
        return ResponseEntity.ok(tp);
    }

    @PostMapping
    public ResponseEntity<TravelPackage> createPackage(@RequestBody TravelPackage tp) {
        TravelPackage saved = packageService.savePackage(tp);
        return ResponseEntity.ok(saved);
    }
}
