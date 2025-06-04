package com.travelbooking.travelapp.repository;

import com.travelbooking.travelapp.model.ContactMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactMessageRepository extends JpaRepository<ContactMessage, Long> {
}
