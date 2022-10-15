package com.example.pract5.rest;

import com.example.pract5.model.Contact;
import com.example.pract5.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContactController {
    @Autowired
    private ContactService contactService;

    @GetMapping("/getAll")
    public List<Contact> getAll(){
        return contactService.getAll();
    }

    @PostMapping("/create")
    public void createNewContact(@RequestBody Contact contact){contactService.createContact(contact);}

    @PutMapping("/update")
    public void updateContact(@RequestBody Contact contact){
        System.out.println(contact);
        contactService.updateContact(contact);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteContact(@PathVariable Long id){
        contactService.deleteContact(id);
    }
}
