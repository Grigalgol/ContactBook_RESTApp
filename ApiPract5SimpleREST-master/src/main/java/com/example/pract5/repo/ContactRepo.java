package com.example.pract5.repo;

import com.example.pract5.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepo extends JpaRepository<Contact, Long> {
    Contact findContactById(Long id);
}
