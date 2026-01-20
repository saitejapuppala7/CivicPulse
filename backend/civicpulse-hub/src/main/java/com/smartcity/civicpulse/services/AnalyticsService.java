package com.smartcity.civicpulse.services;

import com.smartcity.civicpulse.repository.ComplaintRepository;
import com.smartcity.civicpulse.security.JwtService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AnalyticsService {
    public ComplaintRepository complaintRepository;
    public JwtService jwtService;
    public AnalyticsService(ComplaintRepository complaintRepository,JwtService jwtService)
    {
        this.complaintRepository=complaintRepository;
        this.jwtService=jwtService;

    }

    public Map<String, Long> getCategoryWise()
    {
        List<Object[]> results = complaintRepository.countByDepartment();

        Map<String, Long> categoryMap = new HashMap<>();

        for (Object[] row : results) {
            String category = (String) row[0];
            Long count = (Long) row[1];
            categoryMap.put(category, count);
        }

        return categoryMap;

    }
    public List<Map<String, Object>> getRedZones() {

        List<Object[]> results = complaintRepository.findRedZones();

        List<Map<String, Object>> response = new ArrayList<>();

        for (Object[] row : results) {
            Map<String, Object> map = new HashMap<>();
            map.put("zone", row[0]);
            map.put("count", row[1]);
            response.add(map);
        }

        return response;
    }
    public Map<String, Long> getZoneWise() {

        List<Object[]> results = complaintRepository.countByZone();

        Map<String, Long> map = new HashMap<>();
        System.out.println("zone service");

        for (Object[] row : results) {
            String zone = (String) row[0];
            Long count = (Long) row[1];
            if(zone!=null) {
                map.put(zone, count);
            }
        }

        return map;
    }
    public Map<String, Long> getSlaReport() {

        Object[] outer = complaintRepository.getSlaStats();   // [[met, missed]]
        Object[] row = (Object[]) outer[0];                   // [met, missed]

        Long slaMet = row[0] == null ? 0L : ((Number) row[0]).longValue();
        Long slaMissed = row[1] == null ? 0L : ((Number) row[1]).longValue();

        Map<String, Long> result = new HashMap<>();
        result.put("slaMet", slaMet);
        result.put("slaMissed", slaMissed);

        return result;
    }






}
