package com.smartcity.civicpulse.repository;

import com.smartcity.civicpulse.entity.Department;
import com.smartcity.civicpulse.entity.Officer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfficerRepository extends JpaRepository<Officer,Long> {
    Officer findByDepartment(Department department);
}
