package com.smartcity.civicpulse.repository;

import com.smartcity.civicpulse.entity.Citizen;
import com.smartcity.civicpulse.entity.Complaint;
import com.smartcity.civicpulse.entity.Department;
import com.smartcity.civicpulse.entity.User;
import com.smartcity.civicpulse.enums.ComplaintStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComplaintRepository extends JpaRepository<Complaint,Long> {
    List<Complaint> findByCitizen(Citizen citizen);
    List<Complaint> findByStatus(ComplaintStatus status);
    List<Complaint> findByDepartmentAndStatus(Department department,ComplaintStatus status);



}
