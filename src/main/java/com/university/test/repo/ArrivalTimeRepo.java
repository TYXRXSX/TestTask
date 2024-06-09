package com.university.test.repo;

import com.university.test.entity.ArrivalTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArrivalTimeRepo extends JpaRepository<ArrivalTime, Integer> {
}
