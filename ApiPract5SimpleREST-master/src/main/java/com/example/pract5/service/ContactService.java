package com.example.pract5.service;

import com.example.pract5.model.Contact;
import com.example.pract5.repo.ContactRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {
    @Autowired
    private ContactRepo contactRepo;

    public List<Contact> getAll(){
        return contactRepo.findAll();
    }

    public void updateContact(Contact contact){
        Contact contactToUpdate = contactRepo.findContactById(contact.getId());
        contactToUpdate.setName(contact.getName());
        contactToUpdate.setPhone(contact.getPhone());
        contactRepo.save(contactToUpdate);
    }

    public void deleteContact(Long id){
        contactRepo.delete(contactRepo.findContactById(id));
    }

    public void createContact(Contact contact){
        contactRepo.save(contact);
    }

    public Contact getContactById(Long id) { return contactRepo.findContactById(id);}
}
