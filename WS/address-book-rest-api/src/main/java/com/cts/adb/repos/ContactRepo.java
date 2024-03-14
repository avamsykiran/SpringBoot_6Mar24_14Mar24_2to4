package com.cts.adb.repos;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cts.adb.entities.Contact;

public interface ContactRepo extends JpaRepository<Contact, Integer> {
	
    boolean existsByMobileNumber(String mobileNumber);
    Optional<Contact> findByMobileNumber(String mobileNumber);
    List<Contact> findAllByFullName(String fullName);
    void deleteByMobileNumber(String mobileNumber);

    @Query("SELECT c FROM Contact c WHERE c.dateOfBith BETWEEN :start AND :end")
    List<Contact> getAllBornIn(LocalDate start,LocalDate end);

}
