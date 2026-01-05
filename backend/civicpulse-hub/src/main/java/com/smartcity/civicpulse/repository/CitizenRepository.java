package com.smartcity.civicpulse.repository;

import com.smartcity.civicpulse.entity.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitizenRepository extends JpaRepository<Citizen,Long> {

    Citizen findByEmail(String eamil);
}
