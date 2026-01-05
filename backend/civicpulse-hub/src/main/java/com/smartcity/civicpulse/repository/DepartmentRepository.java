package com.smartcity.civicpulse.repository;

import com.smartcity.civicpulse.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository <Department, Long >{

    Department findByName(String name);
}
