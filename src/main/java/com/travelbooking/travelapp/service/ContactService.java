package com.travelbooking.travelapp.service;

import com.travelbooking.travelapp.model.ContactMessage;
import com.travelbooking.travelapp.repository.ContactMessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {
    private final ContactMessageRepository contactRepo;

    public ContactService(ContactMessageRepository contactRepo){
        this.contactRepo = contactRepo;
    }

    public ContactMessage saveMessage(ContactMessage msg){
        return contactRepo.save(msg);
    }

    public List<ContactMessage>getAllMessages(){
        return contactRepo.findAll();
    }
}
