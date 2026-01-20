package com.smartcity.civicpulse.repository;

import com.smartcity.civicpulse.entity.Citizen;
import com.smartcity.civicpulse.entity.Complaint;
import com.smartcity.civicpulse.entity.Department;
import com.smartcity.civicpulse.entity.User;
import com.smartcity.civicpulse.enums.ComplaintStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComplaintRepository extends JpaRepository<Complaint,Long> {
    List<Complaint> findByCitizen(Citizen citizen);
    List<Complaint> findByStatus(ComplaintStatus status);
    List<Complaint> findByDepartmentAndStatus(Department department,ComplaintStatus status);
    @Query("""
SELECT d.name, COUNT(c)
FROM Complaint c
JOIN c.department d
GROUP BY d.name
""")
    List<Object[]> countByDepartment();
    @Query("""
SELECT c.zone, COUNT(c)
FROM Complaint c
GROUP BY c.zone
""")
    List<Object[]> countByZone();
    @Query("""
SELECT c.zone, COUNT(c)
FROM Complaint c
GROUP BY c.zone
HAVING COUNT(c) >= 0
""")
    List<Object[]> findRedZones();
    @Query(value = """
SELECT
  SUM(CASE
      WHEN resolved_at IS NOT NULL
       AND resolved_at <= DATE_ADD(created_at, INTERVAL 24 HOUR)
      THEN 1 ELSE 0 END),

  SUM(CASE
      WHEN resolved_at IS NOT NULL
       AND resolved_at > DATE_ADD(created_at, INTERVAL 24 HOUR)
      THEN 1 ELSE 0 END)
FROM complaints
""", nativeQuery = true)
    Object[] getSlaStats();


}
