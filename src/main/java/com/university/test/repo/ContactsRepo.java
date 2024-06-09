package com.university.test.repo;

import com.university.test.entity.Contacts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactsRepo extends JpaRepository<Contacts, Integer> {
}
