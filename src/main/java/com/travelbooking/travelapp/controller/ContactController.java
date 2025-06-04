package com.travelbooking.travelapp.controller;


import com.travelbooking.travelapp.model.ContactMessage;
import com.travelbooking.travelapp.service.ContactService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/contact")
public class ContactController {
    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<ContactMessage> submitContact(
            @Valid @RequestBody ContactMessage payload) {
        // payload should contain name, email, subject, message
        ContactMessage saved = contactService.saveMessage(payload);
        return ResponseEntity.status(201).body(saved);
    }

    // Optional: for admin review
    @GetMapping
    public ResponseEntity<?> getAllMessages() {
        return ResponseEntity.ok(contactService.getAllMessages());
    }
}
